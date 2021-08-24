package com.stockbit.repository

import CryptoResponse
import Data
import com.stockbit.remote.CoinDataSource
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface CoinRepository {
    suspend fun getCoin(limit: Int, tsym: String): Flow<Resource<List<Data>>>
}

class CoinRepositoryImpl(
    private val dataSource: CoinDataSource
): CoinRepository{
    override suspend fun getCoin(limit: Int, tsym: String): Flow<Resource<List<Data>>> {
        return flow {
            val result = dataSource.fetchTopVolCoinAsync(limit, tsym)
                if (result.isSuccessful){
                    result.body()?.let {
                        emit(Resource.success(it.data))
                    }

                }else{
                    emit(Resource.error(Throwable(result.message()), null))
                }
        }.flowOn(Dispatchers.IO)
    }

}
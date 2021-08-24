package com.stockbit.remote

import CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinService {
    @GET("data/top/totaltoptiervolfull")
    fun fetchCoinAsync(
        @Query("limit") limit: Int,
        @Query("tsym") tsym: String
    ): Response<CryptoResponse>
}
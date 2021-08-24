package com.stockbit.watchlist

import Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stockbit.common.base.BaseViewModel
import com.stockbit.repository.CoinRepository
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class WatchListViewModel(
    private val coinRepository: CoinRepository
): BaseViewModel() {

    private val _coins = MutableLiveData<List<Data>>()
    val coins: LiveData<List<Data>>
        get() = _coins

    fun fetchCoin(){
        viewModelScope.launch {
            coinRepository.getCoin(10, "USD")
                .onStart {  }
                .catch {  }
                .collect {
                    _coins.value = it.data
                }
        }
    }

}
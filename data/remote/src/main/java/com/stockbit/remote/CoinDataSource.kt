package com.stockbit.remote

class CoinDataSource(
    private val coinService: CoinService
) {
    fun fetchTopVolCoinAsync(limit: Int, tsym: String) =
        coinService.fetchCoinAsync(limit, tsym)
}
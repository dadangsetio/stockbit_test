package com.stockbit.remote.di

import android.util.Log
import com.stockbit.remote.CoinDataSource
import com.stockbit.remote.CoinService
import com.stockbit.remote.ExampleDatasource
import com.stockbit.remote.ExampleService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseUrl: String, token: String) = module {

    factory<Interceptor> {
        HttpLoggingInterceptor().level = HttpLoggingInterceptor.Level.HEADERS
        Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
            request.addHeader("Authorization", "Apikey $token")

            val buildRequest = request.build()

            return@Interceptor  chain.proceed(buildRequest)
        }
    }

    factory { OkHttpClient.Builder().addInterceptor(get()).build() }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory{ get<Retrofit>().create(ExampleService::class.java) }

    factory { ExampleDatasource(get()) }

    factory { get<Retrofit>().create(CoinService::class.java) }

    factory { CoinDataSource(get()) }
}
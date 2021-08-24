package com.stockbit.hiring.di

import com.stockbit.local.di.localModule
import com.stockbit.remote.di.createRemoteModule
import com.stockbit.repository.di.repositoryModule

val appComponent= listOf(createRemoteModule(
    "https://api.github.com/",
    "0889fcb6782bf1ca60cddb54381dd485c63178ae1751aeda8c9cffbd090c6960"
), repositoryModule, localModule)
package com.vinutest.koin_jetpack_compose.presentation.di

import com.vinutest.koin_jetpack_compose.data.UserRepository
import com.vinutest.koin_jetpack_compose.data.UserRepositoryImpl
import com.vinutest.koin_jetpack_compose.data.UserStateHolder
import org.koin.dsl.module

val appModule = module {
    single<UserRepository> { UserRepositoryImpl() }
    factory { UserStateHolder(get()) }
}
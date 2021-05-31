package com.b21_cap0183.paddycare.core.di

import com.b21_cap0183.paddycare.core.data.source.PaddyRepository
import com.b21_cap0183.paddycare.core.data.source.local.LocalDataSource
import com.b21_cap0183.paddycare.core.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): PaddyRepository = PaddyRepository(remoteDataSource,localDataSource)
}
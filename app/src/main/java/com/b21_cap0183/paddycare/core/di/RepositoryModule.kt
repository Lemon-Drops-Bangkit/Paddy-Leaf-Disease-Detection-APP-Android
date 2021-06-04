package com.b21_cap0183.paddycare.core.di

import com.b21_cap0183.paddycare.core.data.source.PaddyRepository
import com.b21_cap0183.paddycare.core.data.source.local.LocalDataSource
import com.b21_cap0183.paddycare.core.data.source.remote.RemoteDataSource
import com.b21_cap0183.paddycare.core.domain.repository.IPaddyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [RetrofitModule::class, RoomModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(paddyRepository: PaddyRepository): IPaddyRepository
}
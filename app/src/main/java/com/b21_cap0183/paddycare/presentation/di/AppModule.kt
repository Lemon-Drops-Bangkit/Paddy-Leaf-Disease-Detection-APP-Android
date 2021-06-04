package com.b21_cap0183.paddycare.presentation.di

import com.b21_cap0183.paddycare.core.domain.usecase.PaddyInteractor
import com.b21_cap0183.paddycare.core.domain.usecase.PaddyUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun providePaddyUseCase(paddyInteractor: PaddyInteractor): PaddyUseCase
}
package com.b21_cap0183.paddycare.core.di

import android.content.Context
import androidx.room.Room
import com.b21_cap0183.paddycare.core.data.source.local.room.PaddyDao
import com.b21_cap0183.paddycare.core.data.source.local.room.PaddyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providePaddyDb(@ApplicationContext context: Context): PaddyDatabase {
        return Room.databaseBuilder(
            context,
            PaddyDatabase::class.java,
            PaddyDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePaddyDao(database: PaddyDatabase): PaddyDao = database.PaddyDao()
}
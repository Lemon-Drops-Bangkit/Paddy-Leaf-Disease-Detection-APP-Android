package com.b21_cap0183.paddycare.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.data.source.local.entity.ResultEntity
import javax.inject.Singleton

@Database(entities = [DiseaseEntity::class, ResultEntity::class], version = 2, exportSchema = false)
@Singleton
abstract class PaddyDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "Paddy.db"
    }

    abstract fun PaddyDao(): PaddyDao
}
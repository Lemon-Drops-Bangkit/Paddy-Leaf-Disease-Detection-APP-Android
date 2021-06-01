package com.b21_cap0183.paddycare.core.data.source.local

import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.data.source.local.room.PaddyDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val paddyDao: PaddyDao) {

    fun getAllDisease(): Flow<List<DiseaseEntity>> = paddyDao.getAllDisease()

    fun getDiseaseById(id: Int): Flow<DiseaseEntity> = paddyDao.getDiseaseById(id)

    suspend fun insertDisease(diseaseList: List<DiseaseEntity>) = paddyDao.insertDisease(diseaseList)

}
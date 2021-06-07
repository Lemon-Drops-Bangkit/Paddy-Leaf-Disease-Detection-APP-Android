package com.b21_cap0183.paddycare.core.data.source.local

import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.data.source.local.entity.ResultEntity
import com.b21_cap0183.paddycare.core.data.source.local.room.PaddyDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val paddyDao: PaddyDao) {

    fun getAllDisease(): Flow<List<DiseaseEntity>> = paddyDao.getAllDisease()

    suspend fun insertDisease(diseaseList: List<DiseaseEntity>) = paddyDao.insertDisease(diseaseList)

    fun getAllResult(): Flow<List<ResultEntity>> = paddyDao.getAllResult()

    fun getResultById(id: Int): Flow<ResultEntity> = paddyDao.getResultById(id)

    suspend fun insertResult(resultList: List<ResultEntity>) = paddyDao.insertResult(resultList)

    fun updateResult(result: ResultEntity) = paddyDao.updateResult(result)

    fun deleteResult(resultEntity: ResultEntity) = paddyDao.deleteResult(resultEntity)
}
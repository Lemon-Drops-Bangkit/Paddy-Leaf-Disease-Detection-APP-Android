package com.b21_cap0183.paddycare.core.data.source.local.room

import androidx.room.*
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.data.source.local.entity.ResultEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaddyDao {

    @Query("SELECT * FROM paddydisesase")
    fun getAllDisease(): Flow<List<DiseaseEntity>>

    @Query("SELECT * FROM paddydisesase WHERE diseaseId = :id")
    fun getDiseaseById(id: Int): Flow<DiseaseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDisease(disease: List<DiseaseEntity>)

    @Update
    fun updateDisease(disease: DiseaseEntity)

    //Result

    @Query("SELECT * FROM paddyresult ORDER BY resultId DESC")
    fun getAllResult(): Flow<List<ResultEntity>>

    @Query("SELECT * FROM paddyresult")
    fun getResult(): Flow<List<ResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: List<ResultEntity>)

    @Delete
    fun deleteResult(result: ResultEntity)
}
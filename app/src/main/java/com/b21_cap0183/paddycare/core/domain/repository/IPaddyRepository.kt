package com.b21_cap0183.paddycare.core.domain.repository

import com.b21_cap0183.paddycare.core.data.source.Resource
import com.b21_cap0183.paddycare.core.data.source.local.entity.ResultEntity
import com.b21_cap0183.paddycare.core.domain.model.Disease
import com.b21_cap0183.paddycare.core.domain.model.Result
import kotlinx.coroutines.flow.Flow
import java.io.File

interface IPaddyRepository {
    fun getAllDisease(): Flow<Resource<List<Disease>>>

    fun getAllResult(): Flow<Resource<List<Result>>>

    fun postResult(image: File): Flow<Resource<Result>>

    //fun deleteResult(resultEntity: ResultEntity)
}
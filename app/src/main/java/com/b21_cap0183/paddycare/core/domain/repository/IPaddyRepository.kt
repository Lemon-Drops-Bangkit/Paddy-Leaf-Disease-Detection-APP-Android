package com.b21_cap0183.paddycare.core.domain.repository

import androidx.lifecycle.LiveData
import com.b21_cap0183.paddycare.core.data.source.Resource
import com.b21_cap0183.paddycare.core.domain.model.Disease
import com.b21_cap0183.paddycare.core.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface IPaddyRepository {

    fun getAllDisease(): LiveData<Resource<List<Disease>>>

    fun getDiseaseById(id: Int): LiveData<Resource<Disease>>

    fun getAllResult(): LiveData<Resource<List<Result>>>

    fun getResultById(id: Int): LiveData<Resource<Result>>
}
package com.b21_cap0183.paddycare.core.data.source

import androidx.lifecycle.LiveData
import com.b21_cap0183.paddycare.core.data.source.local.LocalDataSource
import com.b21_cap0183.paddycare.core.data.source.remote.RemoteDataSource
import com.b21_cap0183.paddycare.core.data.source.remote.network.ApiResponse
import com.b21_cap0183.paddycare.core.data.source.remote.response.DiseaseResponse
import com.b21_cap0183.paddycare.core.domain.model.Disease
import com.b21_cap0183.paddycare.core.domain.repository.IPaddyRepository
import com.b21_cap0183.paddycare.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PaddyRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IPaddyRepository {

    override fun getAllDisease(): LiveData<Resource<List<Disease>>> {
        TODO("Not yet implemented")
    }

    override fun getDiseaseById(id: Int): LiveData<Resource<Disease>> {
        TODO("Not yet implemented")
    }

}
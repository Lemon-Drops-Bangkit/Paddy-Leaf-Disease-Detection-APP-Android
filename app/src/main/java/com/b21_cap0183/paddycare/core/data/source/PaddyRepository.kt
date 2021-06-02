package com.b21_cap0183.paddycare.core.data.source

import androidx.lifecycle.LiveData
import com.b21_cap0183.paddycare.core.data.source.local.LocalDataSource
import com.b21_cap0183.paddycare.core.data.source.remote.RemoteDataSource
import com.b21_cap0183.paddycare.core.domain.model.Disease
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.core.domain.repository.IPaddyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaddyRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IPaddyRepository {

    override fun getAllDisease(): LiveData<Resource<List<Disease>>> {
        TODO("Not yet implemented")
    }

    override fun getDiseaseById(id: Int): LiveData<Resource<Disease>> {
        TODO("Not yet implemented")
    }

    override fun getAllResult(): LiveData<Resource<List<Result>>> {
        TODO("Not yet implemented")
    }

    override fun getResultById(id: Int): LiveData<Resource<Result>> {
        TODO("Not yet implemented")
    }

}
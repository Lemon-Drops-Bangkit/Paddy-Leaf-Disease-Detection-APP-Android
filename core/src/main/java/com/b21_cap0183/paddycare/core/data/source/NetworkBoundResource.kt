package com.b21_cap0183.paddycare.core.data.source

import android.util.Log
import com.b21_cap0183.paddycare.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        val dbSource = loadFromDB().first()
        Log.d("1", "tolol")
        if (shouldFetch(dbSource)) {
            Log.d("1", shouldFetch(dbSource).toString())
            emit(Resource.Loading())
            Log.d("Load", "ing")
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    Log.d("Load1", apiResponse.toString())
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { Resource.Success(it) })
                    Log.d("Succ", "ess")
                }
                is ApiResponse.Empty -> {
                    Log.d("Load2", apiResponse.toString())
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResponse.Error -> {
                    Log.d("Load3", apiResponse.toString())
                    onFetchFailed()
                    emit(Resource.Error<ResultType>(apiResponse.errorMessage))
                }
            }
        } else {
            Log.d("1", shouldFetch(dbSource).toString())
            emitAll(loadFromDB().map { Resource.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result
}
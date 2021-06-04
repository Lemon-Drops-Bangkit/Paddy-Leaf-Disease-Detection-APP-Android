package com.b21_cap0183.paddycare.core.data.source.remote.network

import com.b21_cap0183.paddycare.core.data.source.remote.response.ListDiseaseResponse
import com.b21_cap0183.paddycare.core.data.source.remote.response.ResultResponse
import retrofit2.http.*

interface ApiService {
    @GET("dictionary")
    suspend fun getAllDisease(): ListDiseaseResponse

    @Multipart
    @POST("predict")
    suspend fun postPredict(): ResultResponse
}
package com.b21_cap0183.paddycare.core.data.source.remote.network

import com.b21_cap0183.paddycare.core.data.source.remote.response.ListDiseaseResponse
import com.b21_cap0183.paddycare.core.data.source.remote.response.ResultResponse
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @GET("dictionary")
    suspend fun getAllDisease(): ListDiseaseResponse

    @Multipart
    @POST("predict")
    suspend fun postPredict(@Part images: MultipartBody.Part): ResultResponse
}
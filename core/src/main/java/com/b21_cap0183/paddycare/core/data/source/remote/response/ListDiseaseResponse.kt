package com.b21_cap0183.paddycare.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListDiseaseResponse(

    @field:SerializedName("Page")
    val page: String,

    @field:SerializedName("Result")
    val result: List<DiseaseResponse>
)
package com.b21_cap0183.paddycare.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DiseaseResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("solution")
    val solution: String,

    @field:SerializedName("picture")
    val picture: Int
)
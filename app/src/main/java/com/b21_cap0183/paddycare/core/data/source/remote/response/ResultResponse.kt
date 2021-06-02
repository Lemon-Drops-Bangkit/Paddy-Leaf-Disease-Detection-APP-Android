package com.b21_cap0183.paddycare.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResultResponse(
     @field: SerializedName("id")
    val id: Int,

    @field:SerializedName("label")
    val label: String,

    @field:SerializedName("description")
    val desc: String,

    @field:SerializedName("solution")
    val solution: String
)
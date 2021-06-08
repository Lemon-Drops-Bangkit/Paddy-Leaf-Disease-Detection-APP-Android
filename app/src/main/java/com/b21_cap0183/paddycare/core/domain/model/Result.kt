package com.b21_cap0183.paddycare.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    var resultId: Long,
    var resultDate: String,
    var resultName: String,
    var resultDesc: String,
    var resultSolution: String,
    var resultImage: String
) : Parcelable
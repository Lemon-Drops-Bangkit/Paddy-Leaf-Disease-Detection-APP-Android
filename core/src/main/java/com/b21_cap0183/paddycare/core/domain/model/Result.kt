package com.b21_cap0183.paddycare.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    var resultId: Long? = null,
    var resultDate: String? = null,
    var resultName: String? = null,
    var resultDesc: String? = null,
    var resultSolution: String? = null,
    var resultImage: String? = null
) : Parcelable
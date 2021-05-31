package com.b21_cap0183.paddycare.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Disease(
    var diseaseId: Int,
    var diseaseName: String,
    var diseaseDesc: String,
    var diseasePicture: Int
) : Parcelable
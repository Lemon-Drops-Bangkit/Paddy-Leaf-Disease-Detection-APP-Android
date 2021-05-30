package com.b21_cap0183.paddycare.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Disease(
    var diseaseId: Int? = null,
    var diseaseName: String? = null,
    var diseaseDesc: String? = null,
    var diseasePicture: Int? = null
) : Parcelable
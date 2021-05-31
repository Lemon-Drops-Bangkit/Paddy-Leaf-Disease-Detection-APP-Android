package com.b21_cap0183.paddycare.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paddydisesase")
data class DiseaseEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "diseaseId")
    var diseaseId: Int,

    @ColumnInfo(name = "diseaseName")
    var diseaseName: String,

    @ColumnInfo(name = "diseaseDesc")
    var diseaseDesc: String,

    @ColumnInfo(name = "diseasePicture")
    var diseasePicture: Int
)
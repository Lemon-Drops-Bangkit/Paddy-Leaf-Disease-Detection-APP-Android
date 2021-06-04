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

    @ColumnInfo(name = "diseaseDescription")
    var diseaseDescription: String,

    @ColumnInfo(name = "diseaseSolution")
    var diseaseSolution: String,

    @ColumnInfo(name = "diseaseImage")
    var diseaseImage: String
)
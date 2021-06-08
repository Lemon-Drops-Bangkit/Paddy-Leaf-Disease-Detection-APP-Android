package com.b21_cap0183.paddycare.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paddyresult")
data class ResultEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "resultId")
    var resultId: Long,

    @ColumnInfo(name = "resultName")
    var resultName: String,

    @ColumnInfo(name = "resultDesc")
    var resultDesc: String,

    @ColumnInfo(name = "resultSolution")
    var resultSolution: String,

    @ColumnInfo(name = "resultImage")
    var resultImage: String
)

package com.b21_cap0183.paddycare.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paddyresult")
data class ResultEntity(
    @PrimaryKey
    @ColumnInfo(name = "resultId")
    var resultId: Long? = null,

    @ColumnInfo(name = "date")
    var resultDate: String? = null,

    @ColumnInfo(name = "resultName")
    var resultName: String? = null,

    @ColumnInfo(name = "resultDesc")
    var resultDesc: String? = null,

    @ColumnInfo(name = "resultSolution")
    var resultSolution: String? = null,

    @ColumnInfo(name = "resultImage")
    var resultImage: String? = null
)

package com.project.ggyucoinproject.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "market")
data class MarketEntity(
    @PrimaryKey val market: String,
    @ColumnInfo(name = "korean_name") val koreanName: String,
    @ColumnInfo(name = "english_name") val englishName: String,
)
package com.project.ggyucoinproject.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.ggyucoinproject.data.dao.FavoriteDao
import com.project.ggyucoinproject.data.dao.MarketDao
import com.project.ggyucoinproject.data.entity.FavoriteEntity
import com.project.ggyucoinproject.data.entity.MarketEntity

@Database(entities = [FavoriteEntity::class, MarketEntity::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    abstract fun marketDao(): MarketDao
}
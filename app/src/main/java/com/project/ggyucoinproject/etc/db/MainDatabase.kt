package com.project.ggyucoinproject.etc.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.ggyucoinproject.entity.FavoriteEntity
import com.project.ggyucoinproject.entity.MarketEntity

@Database(entities = [FavoriteEntity::class, MarketEntity::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    abstract fun marketDao(): MarketDao
}
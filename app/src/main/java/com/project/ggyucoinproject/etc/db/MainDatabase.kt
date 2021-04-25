package com.project.ggyucoinproject.etc.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.ggyucoinproject.entity.FavoriteEntity

@Database(entities = [FavoriteEntity::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun marketDao(): FavoriteDao
}
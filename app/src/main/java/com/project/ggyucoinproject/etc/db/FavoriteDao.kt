package com.project.ggyucoinproject.etc.db

import androidx.room.*
import com.project.ggyucoinproject.entity.FavoriteEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    suspend fun getAll(): List<FavoriteEntity>

    @Query("SELECT * FROM favorite WHERE market == :market")
    suspend fun get(market: String?): FavoriteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg favorites: FavoriteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteEntity)

    @Delete
    suspend fun delete(favorite: FavoriteEntity)
}
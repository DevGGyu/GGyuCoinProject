package com.project.ggyucoinproject.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.ggyucoinproject.data.entity.MarketEntity

@Dao
interface MarketDao {

    @Query("SELECT * FROM market")
    suspend fun getAll(): List<MarketEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg markets: MarketEntity)
}
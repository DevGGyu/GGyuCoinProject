package com.project.ggyucoinproject.etc.module

import android.content.Context
import androidx.room.Room
import com.project.ggyucoinproject.etc.db.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MainDatabase {
        return Room
            .databaseBuilder(context, MainDatabase::class.java, "market-db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
package com.project.ggyucoinproject.etc.module

import android.content.Context
import androidx.room.Room
import com.project.ggyucoinproject.BuildConfig
import com.project.ggyucoinproject.etc.api.MarketService
import com.project.ggyucoinproject.etc.db.MainDatabase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val restModule = module {

    single { provideService(get(), get()) }

    factory { provideOkHttpClient(get()) }

    factory { provideMoshi() }

    factory { provideHttpLoggingInterceptor() }

    single { provideDatabase(androidApplication()) }


}

private fun provideService(okHttpClient: OkHttpClient, moshi: Moshi): MarketService {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://api.upbit.com/v1/")
        .client(okHttpClient)
        .build().create(MarketService::class.java)
}

private fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .build()
}

private fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        this.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }
}

private fun provideDatabase(context: Context): MainDatabase {
    return Room
        .databaseBuilder(context, MainDatabase::class.java, "market-db")
        .fallbackToDestructiveMigration()
        .build()
}
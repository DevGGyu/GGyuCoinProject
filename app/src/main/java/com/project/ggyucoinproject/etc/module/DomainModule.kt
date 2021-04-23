package com.project.ggyucoinproject.etc.module

import com.project.ggyucoinproject.etc.api.MarketService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val restModule = module {

    single { provideService(get(), get()) }

    factory { provideOkHttpClient(get()) }

    factory { provideMoshi() }

    factory { provideHttpLoggingInterceptor() }
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
        this.level = HttpLoggingInterceptor.Level.BODY
    }
}
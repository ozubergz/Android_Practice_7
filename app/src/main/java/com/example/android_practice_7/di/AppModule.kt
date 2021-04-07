package com.example.android_practice_7.di

import com.example.android_practice_7.data.remote.CoinService
import com.example.android_practice_7.other.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val client = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }.let {
            OkHttpClient.Builder().addInterceptor(it).build()
        }

    @Singleton
    @Provides
    fun provideCoinApi() : CoinService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
        .create(CoinService::class.java)

}
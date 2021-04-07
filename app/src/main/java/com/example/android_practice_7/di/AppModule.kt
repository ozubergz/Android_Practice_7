package com.example.android_practice_7.di

import android.content.Context
import androidx.room.Room
import com.example.android_practice_7.data.local.CoinDatabase
import com.example.android_practice_7.data.remote.CoinService
import com.example.android_practice_7.other.Constants
import com.example.android_practice_7.other.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideCoinDatabase(@ApplicationContext context: Context) : CoinDatabase =
        Room.databaseBuilder(
            context,
            CoinDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideCoinDao(coinDatabase: CoinDatabase) = coinDatabase.coinDao()

}
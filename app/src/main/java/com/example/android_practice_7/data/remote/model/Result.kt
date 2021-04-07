package com.example.android_practice_7.data.remote.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
@Entity
data class Result(
    @PrimaryKey val id: Int = 0,
    val data: List<Coin>
) : Parcelable
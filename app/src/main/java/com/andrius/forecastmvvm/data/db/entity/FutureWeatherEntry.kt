package com.andrius.forecastmvvm.data.db.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.andrius.forecastmvvm.data.db.entity.Day
import com.google.gson.annotations.SerializedName

@Entity(tableName = "future_weather", indices = [Index(value = ["date"], unique = true)])
data class FutureWeatherEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val date: String,
    @Embedded
    val day: Day
)
package com.andrius.forecastmvvm.data.db.entity


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "entity")
data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)
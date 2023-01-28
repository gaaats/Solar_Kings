package com.fuzzyhouse.wonderwoollie.apiii

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface DevilApi {
    @GET("typo.json")
    suspend fun getDataDev(): Response<DevilDataEntity>
}

@Keep
data class DevilDataEntity(
    @SerializedName("geo")
    val geo: String,
    @SerializedName("view")
    val view: String,
    @SerializedName("appsChecker")
    val appsChecker: String,
)
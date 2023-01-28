package com.fuzzyhouse.wonderwoollie.apiii

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface GeoUserApi {
    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getUserGeoCode(): Response<CountryCodeJS>
}

@Keep
data class CountryCodeJS(
    @SerializedName("countryCode")
    val cou: String,
)
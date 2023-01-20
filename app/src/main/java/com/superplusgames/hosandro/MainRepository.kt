package com.superplusgames.hosandro

import com.superplusgames.hosandro.apiii.CountryCodeJS
import com.superplusgames.hosandro.apiii.DevilDataEntity
import retrofit2.Response

interface MainRepository {
    fun loadSavedData()
    fun saveDataToSharedPref()
    suspend fun loadDataFromDevilApi(): Response<DevilDataEntity>
    suspend fun loadDataFromGeoApi():Response<CountryCodeJS>
    fun initLoadFacebook()
    fun initLoadMyTracker()
    fun makeGeoCheck():Boolean
    fun makeNaimingCheck():Boolean
    fun makeDepplinCheck():Boolean
}
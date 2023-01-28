package com.fuzzyhouse.wonderwoollie.data

import com.fuzzyhouse.wonderwoollie.apiii.CountryCodeJS
import com.fuzzyhouse.wonderwoollie.apiii.DevilDataEntity
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
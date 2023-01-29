package com.fuzzyhouse.wonderwoollie.domain

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AFInAppEventParameterName
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.fuzzyhouse.wonderwoollie.apiii.CountryCodeJSgtgtgthyhy
import com.fuzzyhouse.wonderwoollie.apiii.CountryRepogttgtg
import com.fuzzyhouse.wonderwoollie.apiii.DevRepo56665gtgtgtgt
import com.fuzzyhouse.wonderwoollie.apiii.GeoDevghyhyjjuuj
import com.fuzzyhouse.wonderwoollie.entity.Util.AAAAAAPPPPS
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import io.branch.referral.util.BRANCH_STANDARD_EVENT
import io.branch.referral.util.BranchEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViMod(
    private val mainRepository: CountryRepogttgtg,
    private val devRepo: DevRepo56665gtgtgtgt,
    private val shP: SharedPreferences,
    val application: Application
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAdvertisingIdClient()
        }
        viewModelScope.launch(Dispatchers.Main) {
            getData()
        }
    }

    private val _countryCode = MutableLiveData<CountryCodeJSgtgtgthyhy>()
    val countryCode: LiveData<CountryCodeJSgtgtgthyhy>
        get() = _countryCode

    private val _geo = MutableLiveData<GeoDevghyhyjjuuj>()
    val geo: LiveData<GeoDevghyhyjjuuj>
        get() = _geo

    private val _appsData = MutableLiveData<String>()
    val appsData: LiveData<String>
        get() = _appsData

    private val _mainId = MutableLiveData<String?>()
    val mainId: LiveData<String?>
        get() = _mainId


    suspend fun getData() {
        _countryCode.postValue(mainRepository.getDatgttggt().body())
        getDevData()
    }

    suspend fun getDevData() {
        _geo.postValue(devRepo.getDataDev().body())
    }

    fun convers(cont: Context) {
        AppsFlyerLib.getInstance()
            .init(AAAAAAPPPPS, conversionDataListener, application)
        AppsFlyerLib.getInstance().start(cont)
    }

    fun fbDeee(cont: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val deepData = data.targetUri?.host.toString()
                shP.edit().putString("deepSt", deepData).apply()
            }
        }
    }

    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            _appsData.postValue(dataGotten)

            when (data?.get(AFInAppEventParameterName.AF_CHANNEL).toString()) {
                "ACI_Search" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.ACHIEVE_LEVEL).setDescription("ACI_Search")
                        .logEvent(application.applicationContext)

                }
                "ACI_Youtube" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.SHARE).setDescription("ACI_Youtube")
                        .logEvent(application.applicationContext)


                }
                "ACI_Display" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.RATE).setDescription("ACI_Display")
                        .logEvent(application.applicationContext)

                }

                else -> {

                    BranchEvent(BRANCH_STANDARD_EVENT.VIEW_AD).setDescription("NoChannel")
                        .logEvent(application.applicationContext)
                    Log.d("Branch Check", "I'm here, branch bitch! No source though")
                }

            }

        }

        override fun onConversionDataFail(error: String?) {
        }

        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(error: String?) {
        }
    }


    fun getAdvertisingIdClient() {
        val advertisingIdClient = AdvertisingIdClient(application)
        advertisingIdClient.start()
        val idUserAdvertising = advertisingIdClient.info.id.toString()
        _mainId.postValue(idUserAdvertising)
    }

}
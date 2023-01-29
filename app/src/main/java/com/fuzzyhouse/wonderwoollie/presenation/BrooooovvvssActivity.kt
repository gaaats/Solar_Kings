package com.fuzzyhouse.wonderwoollie.presenation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fuzzyhouse.wonderwoollie.uttiils.BeamModel
import com.fuzzyhouse.wonderwoollie.databinding.ActivityBrooooovvvssBinding
import com.fuzzyhouse.wonderwoollie.entity.Util.aps_id
import com.fuzzyhouse.wonderwoollie.entity.Util.linkaa
import com.fuzzyhouse.wonderwoollie.entity.Util.myId
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class BrooooovvvssActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBeamgttggt = ActivityBrooooovvvssBinding.inflate(layoutInflater)
        beamgtgtgt = WebView(this)
        setContentView(beamgtgtgt)
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(beamgtgtgt, true)
        hyjuujuj.webSet(beamgtgtgt)

        beamgtgtgt.webViewClient = CustomViewhy56hy()
        beamgtgtgt.webChromeClient = ChromeClienthyhyhy()
        beamgtgtgt.loadUrl(ururururururururgtgtgt())
    }

    private lateinit var bindBeamgttggt: ActivityBrooooovvvssBinding
    lateinit var beamgtgtgt: WebView


    private val hyjuujuj by viewModel<BeamModel>(
        named("BeamModel")
    )


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode != INPUT_FILE_REQUEST_CODEgtggt || mFilePathCallbackghyhy == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var resultshy: Array<Uri>? = null

        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (mCameraPhotoPathhyhyhy != null) {
                    resultshy = arrayOf(Uri.parse(mCameraPhotoPathhyhyhy))
                }
            } else {
                val dataStringgthyhy = data.dataString
                if (dataStringgthyhy != null) {
                    resultshy = arrayOf(Uri.parse(dataStringgthyhy))
                }
            }
        }
        mFilePathCallbackghyhy!!.onReceiveValue(resultshy)
        mFilePathCallbackghyhy = null
        return
    }

    private var mFilePathCallbackghyhy: ValueCallback<Array<Uri>>? = null
    private var mCameraPhotoPathhyhyhy: String? = null
    private  val INPUT_FILE_REQUEST_CODEgtggt = 1

    inner class CustomViewhy56hy: WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
            try {
                if (URLUtil.isNetworkUrl(url)) {
                    return false
                }
                if (hyjuujuj.appInstalledOrNot(url)) {

                    val intenthyhyhy = Intent(Intent.ACTION_VIEW)
                    intenthyhyhy.data = Uri.parse(url)
                    startActivity(intenthyhyhy)
                } else {

                    Toast.makeText(
                        applicationContext,
                        "Application is not installed",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                        )
                    )
                }
                return true
            } catch (e: Exception) {
                return false
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            saveUrlgthyhy(url)
        }


        override fun onReceivedError(
            view: WebView?,
            errorCode: Int,
            description: String?,
            failingUrl: String?
        ) {
            Toast.makeText(this@BrooooovvvssActivity, description, Toast.LENGTH_SHORT).show()
        }
    }


    inner class ChromeClienthyhyhy : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            filePath: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            mFilePathCallbackghyhy?.onReceiveValue(null)
            mFilePathCallbackghyhy = filePath
            var takePictureIntentghyhyhy: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntentghyhyhy!!.resolveActivity(packageManager) != null) {
                var photoFilehyhy: File? = null
                try {
                    photoFilehyhy = hyhyhyhy65()
                    takePictureIntentghyhyhy.putExtra("PhotoPath", mCameraPhotoPathhyhyhy)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (photoFilehyhy != null) {
                    mCameraPhotoPathhyhyhy = "file:" + photoFilehyhy.absolutePath
                    takePictureIntentghyhyhy.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFilehyhy)
                    )
                } else {
                    takePictureIntentghyhyhy = null
                }
            }
            val contentSelectionIntenthyhyhy = Intent(Intent.ACTION_GET_CONTENT)
            contentSelectionIntenthyhyhy.addCategory(Intent.CATEGORY_OPENABLE)
            contentSelectionIntenthyhyhy.type = "image/*"
            val intentArrayhyhy5hy: Array<Intent?> = takePictureIntentghyhyhy?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val chooserIntenthyyh = Intent(Intent.ACTION_CHOOSER)
            chooserIntenthyyh.putExtra(Intent.EXTRA_INTENT, contentSelectionIntenthyhyhy)
            chooserIntenthyyh.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            chooserIntenthyyh.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArrayhyhy5hy)
            startActivityForResult(chooserIntenthyyh, INPUT_FILE_REQUEST_CODEgtggt)
            return true
        }

        fun hyhyhyhy65(): File? {
            val timeStampghyyh = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileNamehyhy = "JPEG_" + timeStampghyyh + "_"
            val storageDirhyhy = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                imageFileNamehyhy,
                ".jpg",
                storageDirhyhy
            )
        }
    }

    override fun onBackPressed() {

        if (beamgtgtgt.canGoBack()) {
            if (hyhyjuju58) {
                beamgtgtgt.stopLoading()
                beamgtgtgt.loadUrl(urlfififif)
            }
            this.hyhyjuju58 = true
            beamgtgtgt.goBack()
            Handler(Looper.getMainLooper()).postDelayed({
                hyhyjuju58 = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    private fun ururururururururgtgtgt(): String {

        val spoongttgt = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)

        val sharPregtgt = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)

        val linkgttg = sharPregtgt.getString(linkaa, null)
        Log.d("lolo", linkgttg.toString())
        val myTrIdhy56hy = sharPregtgt.getString(myId, null)
        val hyhyhyd = sharPregtgt.getString(aps_id, null)


        when (sharPregtgt.getString("WebInt", null)) {
            "campaign" -> {
                Log.d("lolo", "campaign")

                hyjuujuj.pushToOS(hyhyhyd.toString())
            }
            "deepLink" -> {
                Log.d("lolo", "deepLink")
                hyjuujuj.pushToOS(hyhyhyd.toString())
            }
            "deepLinkNOApps" -> {
                Log.d("lolo", "deepLinkNOApps")
                hyjuujuj.pushToOS(myTrIdhy56hy.toString())
            }
            "geo" -> {
                Log.d("lolo", "geo")
                hyjuujuj.pushToOS(myTrIdhy56hy.toString())
            }
        }
        return spoongttgt.getString("SAVED_URL", linkgttg).toString()
    }

    var urlfififif = ""
    fun saveUrlgthyhy(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (urlfififif == "") {
                urlfififif = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspspghyhyhy = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)
                val ededededededed = spspspspsppspspspghyhyhy.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }
    private var hyhyjuju58 = false

}



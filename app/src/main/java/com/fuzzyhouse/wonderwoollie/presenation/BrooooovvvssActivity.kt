package com.fuzzyhouse.wonderwoollie.presenation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.activity.viewModels
import com.fuzzyhouse.wonderwoollie.data.DataHolder.INPUT_FILE_REQUEST_CODE
import com.fuzzyhouse.wonderwoollie.data.DataHolder.mCameraPhotoPath
import com.fuzzyhouse.wonderwoollie.data.DataHolder.mFilePathCallback
import com.fuzzyhouse.wonderwoollie.databinding.ActivityBrooooovvvssBinding
import com.fuzzyhouse.wonderwoollie.domain.BrovserVeivModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import java.io.File
import java.io.IOException
import java.util.*


@AndroidEntryPoint
@ActivityScoped
class BrooooovvvssActivity : AppCompatActivity() {
    private val brovserVeivModel by viewModels<BrovserVeivModel>()
    private lateinit var bindBeam: ActivityBrooooovvvssBinding
    lateinit var beam: WebView
//    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
//    private var mCameraPhotoPath: String? = null
//    private  val INPUT_FILE_REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBeam = ActivityBrooooovvvssBinding.inflate(layoutInflater)
        setContentView(bindBeam.root)
        beam = bindBeam.vvvvvve
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(beam, true)

        brovserVeivModel.webSet(beam)

        beam.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (brovserVeivModel.appInstalledOrNot(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
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
                saveUrl(url)
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

        beam.webChromeClient = ChromeClient()
        beam.loadUrl(urururururururur())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (mCameraPhotoPath != null) {
                    results = arrayOf(Uri.parse(mCameraPhotoPath))
                }
            } else {
                val dataString = data.dataString
                if (dataString != null) {
                    results = arrayOf(Uri.parse(dataString))
                }
            }
        }
        mFilePathCallback!!.onReceiveValue(results)
        mFilePathCallback = null
        return
    }


    inner class ChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            filePath: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            mFilePathCallback?.onReceiveValue(null)
            mFilePathCallback = filePath
            var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent!!.resolveActivity(packageManager) != null) {
                var photoFile: File? = null
                try {
                    photoFile = createImageFile()
                    takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (photoFile != null) {
                    mCameraPhotoPath = "file:" + photoFile.absolutePath
                    takePictureIntent.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile)
                    )
                } else {
                    takePictureIntent = null
                }
            }
            val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
            contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
            contentSelectionIntent.type = "image/*"
            val intentArray: Array<Intent?> = takePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val chooserIntent = Intent(Intent.ACTION_CHOOSER)
            chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
            chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
            startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE)
            return true
        }

        fun createImageFile(): File? {
            return brovserVeivModel.createImageFile()
        }
    }

    private fun urururururururur(): String {
        return brovserVeivModel.urururururururur()
    }

    var urlfififif = ""
    fun saveUrl(lurlurlurlurlur: String?) {
        brovserVeivModel.saveUrl(lurlurlurlurlur)
    }

    private var jkikiiik = false
    override fun onBackPressed() {
        if (beam.canGoBack()) {
            if (jkikiiik) {
                beam.stopLoading()
                beam.loadUrl(urlfififif)
            }
            this.jkikiiik = true
            beam.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                jkikiiik = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
}


package com.superplusgames.hosandro.maaaincact

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import com.superplusgames.hosandro.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.*

@AndroidEntryPoint
@ActivityScoped
class MainActivity : AppCompatActivity() {

    val ooo = "oooo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
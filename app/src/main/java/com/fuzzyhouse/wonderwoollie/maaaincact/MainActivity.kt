package com.fuzzyhouse.wonderwoollie.maaaincact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fuzzyhouse.wonderwoollie.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
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
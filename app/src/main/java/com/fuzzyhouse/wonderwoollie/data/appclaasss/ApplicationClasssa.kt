package com.fuzzyhouse.wonderwoollie.data.appclaasss

import android.app.Application
import android.content.Context
import com.fuzzyhouse.wonderwoollie.entity.Util.ONESIGNAL_APP_ID
import com.fuzzyhouse.wonderwoollie.entity.Util.instId
import com.fuzzyhouse.wonderwoollie.entity.Util.mtKey
import com.fuzzyhouse.wonderwoollie.entity.Util.myId
import com.fuzzyhouse.wonderwoollie.entity.hyujujuj
import com.fuzzyhouse.wonderwoollie.entity.viewModelModuleghyhy
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import io.branch.referral.Branch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import java.util.*


class ApplicationClasssa : Application() {


    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        Branch.enableTestMode()
        Branch.getAutoInstance(this)

        val shPhyhy = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settingsyhyhy = getSharedPreferences("PREFS_NAME", 0)

        val trackerParamshyjju = MyTracker.getTrackerParams()
        val trackerConfighjuuj = MyTracker.getTrackerConfig()
        val instIDhyju = MyTracker.getInstanceId(this)
        trackerConfighjuuj.isTrackingLaunchEnabled = true
        val IDINjuuj = UUID.randomUUID().toString()

        if (settingsyhyhy.getBoolean("my_first_time", true)) {
            trackerParamshyjju.setCustomUserId(IDINjuuj)
            shPhyhy.edit().putString(myId, IDINjuuj).apply()
            shPhyhy.edit().putString(instId, instIDhyju).apply()
            settingsyhyhy.edit().putBoolean("my_first_time", false).apply()
        } else {
            val shIDINhyhy = shPhyhy.getString(myId, IDINjuuj)
            trackerParamshyjju.setCustomUserId(shIDINhyhy)
        }
        MyTracker.initTracker(mtKey, this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@ApplicationClasssa)
            modules(
                listOf(
                    viewModelModuleghyhy, hyujujuj
                )
            )
        }
    }
}
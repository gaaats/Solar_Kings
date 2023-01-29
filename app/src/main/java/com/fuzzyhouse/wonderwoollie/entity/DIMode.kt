package com.fuzzyhouse.wonderwoollie.entity

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.fuzzyhouse.wonderwoollie.uttiils.BeamModel
import com.fuzzyhouse.wonderwoollie.apiii.ApiInterfaceggtgtgt
import com.fuzzyhouse.wonderwoollie.apiii.CountryRepogttgtg
import com.fuzzyhouse.wonderwoollie.apiii.DevRepo56665gtgtgtgt
import com.fuzzyhouse.wonderwoollie.apiii.HostInterfacegtgtgt
import com.fuzzyhouse.wonderwoollie.domain.ViMod
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideGsonhyujujju(): Gson {
    return GsonBuilder().create()
}

val hyujujuj = module {

    single  <HostInterfacegtgtgt> (named("HostInter")){
        get<Retrofit>(named("RetroDev"))
            .create(HostInterfacegtgtgt::class.java)
    }

    single <ApiInterfaceggtgtgt> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(ApiInterfaceggtgtgt::class.java)
    }
    single<Retrofit>(named("RetroCountry")) {
        Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    single <Retrofit>(named("RetroDev")){
        Retrofit.Builder()
            .baseUrl("http://solarkings.live/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory (named("CountryRep")) {
        CountryRepogttgtg(get(named("ApiInter")))
    }

    factory  (named("DevRep")){
        DevRepo56665gtgtgtgt(get(named("HostInter")))
    }
    single{
        provideGsonhyujujju()
    }
    single (named("SharedPreferences")) {
        provideSharedPrefhyyjuju(androidApplication())
    }
}



val viewModelModuleghyhy = module {
    viewModel (named("MainModel")){
        ViMod((get(named("CountryRep"))), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
    viewModel(named("BeamModel")) {
        BeamModel(get())
    }
}

fun provideSharedPrefhyyjuju(app: Application): SharedPreferences {
    return app.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}


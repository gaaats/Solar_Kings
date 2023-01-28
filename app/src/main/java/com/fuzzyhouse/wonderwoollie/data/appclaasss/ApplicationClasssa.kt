package com.fuzzyhouse.wonderwoollie.data.appclaasss

import android.app.Application
import com.fuzzyhouse.wonderwoollie.data.MainRepository
import com.fuzzyhouse.wonderwoollie.apiii.DevilApi
import com.fuzzyhouse.wonderwoollie.apiii.GeoUserApi
import com.fuzzyhouse.wonderwoollie.data.Constances.LINK_HOST
import com.fuzzyhouse.wonderwoollie.data.MainRepoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class ApplicationClasssa : Application() {
}

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    @Singleton
    fun bindsRepository(impl: MainRepoImpl): MainRepository


}

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providesDevilApi(): DevilApi {

        val devilApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(LINK_HOST)
            .build()
            .create(DevilApi::class.java)

        return devilApi
    }

    @Provides
    @Singleton
    fun providesGeoUserApi(): GeoUserApi {
        val geoUserApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(GeoUserApi::class.java)
        return geoUserApi
    }
}


package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.data.MainRepository
import com.superplusgames.hosandro.apiii.CountryCodeJS
import retrofit2.Response
import javax.inject.Inject

class LoadDataFromGeoApiUseCase @Inject constructor(
    private val repository: MainRepository
) {
     suspend fun loadDataFromGeoApiUseCase(): Response<CountryCodeJS> {
        return repository.loadDataFromGeoApi()
    }
}
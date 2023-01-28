package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import com.fuzzyhouse.wonderwoollie.apiii.CountryCodeJS
import retrofit2.Response
import javax.inject.Inject

class LoadDataFromGeoApiUseCase @Inject constructor(
    private val repository: MainRepository
) {
     suspend fun loadDataFromGeoApiUseCase(): Response<CountryCodeJS> {
        return repository.loadDataFromGeoApi()
    }
}
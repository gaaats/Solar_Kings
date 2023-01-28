package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import com.fuzzyhouse.wonderwoollie.apiii.DevilDataEntity
import retrofit2.Response
import javax.inject.Inject

class LoadDataFromDevilApiUseCase@Inject constructor(
    private val repository: MainRepository
) {
    suspend fun loadDataFromDevilApi(): Response<DevilDataEntity> {
        return repository.loadDataFromDevilApi()
    }
}
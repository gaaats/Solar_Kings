package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.data.MainRepository
import com.superplusgames.hosandro.apiii.DevilDataEntity
import retrofit2.Response
import javax.inject.Inject

class LoadDataFromDevilApiUseCase@Inject constructor(
    private val repository: MainRepository
) {
    suspend fun loadDataFromDevilApi(): Response<DevilDataEntity> {
        return repository.loadDataFromDevilApi()
    }
}
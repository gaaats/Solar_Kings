package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.data.MainRepository
import javax.inject.Inject

class MakeGeoCheckUseCase@Inject constructor(
    private val repository: MainRepository
) {
     fun makeGeoCheckUseCase():Boolean{
        return repository.makeGeoCheck()
    }
}
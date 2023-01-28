package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import javax.inject.Inject

class MakeGeoCheckUseCase@Inject constructor(
    private val repository: MainRepository
) {
     fun makeGeoCheckUseCase():Boolean{
        return repository.makeGeoCheck()
    }
}
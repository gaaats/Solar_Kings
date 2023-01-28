package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import javax.inject.Inject

class InitLoadFacebookUseCase @Inject constructor(
    private val repository: MainRepository
){
    suspend fun initLoadFacebook(){
        repository.initLoadFacebook()
    }
}
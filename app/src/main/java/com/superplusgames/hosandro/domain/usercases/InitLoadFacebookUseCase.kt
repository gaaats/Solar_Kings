package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.MainRepository
import javax.inject.Inject

class InitLoadFacebookUseCase @Inject constructor(
    private val repository: MainRepository
){
    suspend fun initLoadFacebook(){
        repository.initLoadFacebook()
    }
}
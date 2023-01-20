package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.data.MainRepository
import javax.inject.Inject

class InitLoadMyTrackerUseCase@Inject constructor(
    private val repository: MainRepository
) {
    suspend fun initLoadMyTracker(){
        repository.initLoadMyTracker()
    }
}
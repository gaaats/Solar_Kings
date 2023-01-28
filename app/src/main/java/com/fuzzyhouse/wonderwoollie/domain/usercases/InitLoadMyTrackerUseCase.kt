package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import javax.inject.Inject

class InitLoadMyTrackerUseCase@Inject constructor(
    private val repository: MainRepository
) {
    suspend fun initLoadMyTracker(){
        repository.initLoadMyTracker()
    }
}
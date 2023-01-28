package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import javax.inject.Inject

class LoadDataSavedUseCase@Inject constructor(
    private val repository: MainRepository
) {
    fun loadDataSavedUseCase(){
        repository.loadSavedData()
    }
}
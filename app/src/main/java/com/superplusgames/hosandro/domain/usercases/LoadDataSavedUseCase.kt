package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.MainRepository
import javax.inject.Inject

class LoadDataSavedUseCase@Inject constructor(
    private val repository: MainRepository
) {
    fun loadDataSavedUseCase(){
        repository.loadSavedData()
    }
}
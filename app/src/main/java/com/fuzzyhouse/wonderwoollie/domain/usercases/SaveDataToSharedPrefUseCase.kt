package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import javax.inject.Inject

class SaveDataToSharedPrefUseCase @Inject constructor(
    private val repository: MainRepository
) {
     fun saveDataToSharedPrefUseCase (){
        repository.saveDataToSharedPref()
    }
}
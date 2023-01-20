package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.data.MainRepository
import javax.inject.Inject

class SaveDataToSharedPrefUseCase @Inject constructor(
    private val repository: MainRepository
) {
     fun saveDataToSharedPrefUseCase (){
        repository.saveDataToSharedPref()
    }
}
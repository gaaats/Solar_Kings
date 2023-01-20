package com.superplusgames.hosandro.domain.usercases

import com.superplusgames.hosandro.MainRepository
import javax.inject.Inject

class MakeDepplinCheckUseCase@Inject constructor(
    private val repository: MainRepository
) {
     fun makeDepplinCheckUseCase(): Boolean {
        return repository.makeDepplinCheck()
    }
}
package com.fuzzyhouse.wonderwoollie.domain.usercases

import com.fuzzyhouse.wonderwoollie.data.MainRepository
import javax.inject.Inject

class MakeDepplinCheckUseCase@Inject constructor(
    private val repository: MainRepository
) {
     fun makeDepplinCheckUseCase(): Boolean {
        return repository.makeDepplinCheck()
    }
}
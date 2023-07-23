package com.mabgroup.takecare.feature.splash.domain.user_case

import com.mabgroup.takecare.feature.splash.domain.repository.SplashScreenRepository
import kotlinx.coroutines.flow.Flow

class CheckUserLogin(
    private val repository: SplashScreenRepository
) {

    suspend operator fun invoke() : Flow<Boolean> {
        return repository.checkAppLastVersion()
    }
}
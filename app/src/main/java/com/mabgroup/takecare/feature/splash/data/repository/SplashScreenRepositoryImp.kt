package com.example.composeapplication.feature.splash.data.repository

import com.mabgroup.takecare.feature.splash.domain.repository.SplashScreenRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class SplashScreenRepositoryImp : SplashScreenRepository {
    override suspend fun checkAppLastVersion() = flow {
        delay(1000)
        emit(true)
    }

}
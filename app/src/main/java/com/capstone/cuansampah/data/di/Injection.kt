package com.capstone.cuansampah.data.di

import android.content.Context
import com.capstone.cuansampah.data.remote.UserPreference
import com.capstone.cuansampah.data.remote.dataStore
import com.capstone.cuansampah.data.remote.repository.ImageClassificationRepository
<<<<<<< HEAD
import com.capstone.cuansampah.data.remote.repository.UserRepository
=======
import com.capstone.cuansampah.data.remote.repository.RegisterRepository
>>>>>>> origin/master
import com.capstone.cuansampah.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideImageClassificationRepository(context: Context): ImageClassificationRepository{
        val apiService = ApiConfig.getApiService("")
        return ImageClassificationRepository.getInstance(apiService)
    }

<<<<<<< HEAD
    fun provideRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService("")
        return UserRepository.getInstance(apiService)
    }
=======
    fun provideRepository(context:Context): RegisterRepository{
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val token = user.token
        val apiService = ApiConfig.getApiServiceUser(token)
        return RegisterRepository.getInstance(pref, apiService)
    }

>>>>>>> origin/master
}
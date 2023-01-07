package com.kaan.firebasechat

import android.provider.SyncStateContract
import com.kaan.firebasechat.Constants.Constants
import com.kaan.firebasechat.Constants.Constants.Companion.BASE_URL
import com.kaan.firebasechat.`interface`.NotificationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy {
            retrofit.create(NotificationApi::class.java)
        }
    }
}
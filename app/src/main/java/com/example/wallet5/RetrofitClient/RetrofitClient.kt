package com.example.wallet5.RetrofitClient

import com.example.wallet5.Interface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun postBankUser(): ApiInterface {

//        192.168.1.15
//        192.168.54.186
        return Retrofit.Builder().baseUrl("http://192.168.54.186:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }

    fun postBankConnect(): ApiInterface {

//        192.168.1.15
//        192.168.54.186
        return Retrofit.Builder().baseUrl("http://192.168.54.186:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }


    fun getOtp(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.54.186:8080/otp/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun sentPostRegister(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.54.186:8080/auth/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun getRetrofitLogin(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.54.186:8080/auth/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }

    fun postRegister(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.54.186:8080/auth/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }




}
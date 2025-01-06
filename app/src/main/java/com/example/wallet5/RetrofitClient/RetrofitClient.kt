package com.example.wallet5.RetrofitClient

import com.example.wallet5.Interface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //    192.168.1.11 Wifi phong
//        192.168.54.186 Wifi đt
//        192.168.1.9 Wifi nha
    fun postBankUser(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }

    fun postBankConnect(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }

    fun getOtp(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/otp/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun sentPostRegister(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/auth/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun getRetrofitLogin(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/auth/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }

    fun postRegister(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/auth/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun postPreTranfer(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun postCheckOtp(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun postTranfer(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun deleteBankUser(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun getAccount(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun postRecharge(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun postPreWallet(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
    fun postTranferWallet(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.17:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }

}
package com.example.wallet5.Interface


import com.example.wallet5.model.request.Login
import com.example.wallet5.model.Otp
import com.example.wallet5.model.request.Bank
import com.example.wallet5.model.request.PreTranfer
import com.example.wallet5.model.request.Register
import com.example.wallet5.model.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


//    http://localhost:8080/otp/getOtp?numberTo=0377114669
    @GET("getOtp?numberTo=0377114669")
    fun getOtps() :Call<List<Otp>>

//    http://localhost:8080/bankUser/save
//    @POST("register")
//    fun sentPostRegister(@Body post: PostRegister, @Header("Authorization") token :String) : Call<PostRegister>


    @POST("login")
    fun getLogins(@Body post: Login) : Call<LoginResponse>

    //    http://localhost:8080/bankUser/save
    @POST("bankUser/save")
    fun postBank(@Body post: Bank, @Header("Authorization") header: String): Call<BankResponse>

    @POST("register")
    fun postRegisters(@Body post: Register) : Call<RegisterResponse>


//    http://localhost:8080/bankUser/list
    @POST("bankUser/list")
    fun postBankUsers(@Header("Authorization") header: String) : Call<Bank_Connected>

//    http://localhost:8080/transfer/pre-transfer
    @POST("transfer/pre-transfer")
    fun postPreTranfers(@Body post: PreTranfer, @Header("Authorization") header: String) : Call<PreTranferResponse>




}

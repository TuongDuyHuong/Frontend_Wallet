package com.example.wallet5.Interface


import com.example.wallet5.model.request.*
import com.example.wallet5.model.response.PreTranfer.OtpResponse
import com.example.wallet5.model.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface ApiInterface {


//    http://localhost:8080/otp/getOtp?numberTo=0377114669
    @GET("getOtp")
    fun getOtps(@Query("numberTo") numberTo:String , @Header("Authorization") header: String) :Call<List<OtpResponse>>

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

    @POST("otp/check")
    fun postCheckOtps(@Query("otp") otp:String, @Header("Authorization") header: String) : Call<CheckOtpResponse>

    @POST("transfer/transfer")
    fun postTranfers(@Body body: Tranfer, @Header("Authorization") header: String) : Call<TranferResponse>

    @DELETE("bankUser/delete")
    fun deleteBankUsers(@Query("id") id:Int,@Header("Authorization") header: String ): Call<DeleteBankResponse>

    @GET("wallet/account")
    fun getAccounts(@Header("Authorization") header: String) :Call<GetAccountResponse>

    @POST("transfer/recharge")
    fun postRecharges(@Query("id") id :Int, @Query("amount") amount:String, @Header("Authorization") header: String) : Call<RechargeResponse>

    @POST("transfer/pre-transfer")
    fun postPreWallets(@Body post: PreTranferWallet, @Header("Authorization") header: String) : Call<PreResponseWallet>

    @POST("transfer/transfer")
    fun postTranferWallets(@Body body: TranferWallet, @Header("Authorization") header: String) : Call<TranferResponse>
}

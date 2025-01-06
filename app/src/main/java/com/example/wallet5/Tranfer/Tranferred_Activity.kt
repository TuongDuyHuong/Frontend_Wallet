package com.example.wallet5.Tranfer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wallet5.MainActivity
import com.example.wallet5.R
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.model.response.GetAccountResponse
import kotlinx.android.synthetic.main.activity_tranferred.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tranferred_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranferred)

        val i = intent
        val bundle = i.extras
        if (bundle != null) {
            val amount = bundle.getString("amount")
            val nameTo = bundle.getString("nameto")
            val numberAccount = bundle.getString("numberaccount")
            val contentTranfer = bundle.getString("contenttranfer")

            txtAmountOfMoney.setText(amount)
            txtNameOfPartner.setText(nameTo)
            txtAccountBank.setText(numberAccount)
            txtMess.setText(contentTranfer)

        }
        btnBackTranfers.setOnClickListener {
            val i = Intent(this, Tranfer_Activity::class.java)
            startActivity(i)
        }
        btnBackHome.setOnClickListener {
            getAccounts()
            val i2 = Intent(this, MainActivity::class.java)
            startActivity(i2)

        }
    }
    fun getAccounts() {
        val token ="Bearer "+ getAccessToken(this).toString()

        RetrofitClient.getAccount().getAccounts(token).enqueue(object:
            Callback<GetAccountResponse> {
            override fun onResponse(
                call: Call<GetAccountResponse>,
                response: Response<GetAccountResponse>,
            ) {
                if (response.body()?.code == 200) {


                    val accountBalance = response.body()!!.result.accountBalance
                    val username = response.body()!!.result.username
                    saveUserData(applicationContext,accountBalance,username)

                }
            }

            override fun onFailure(call: Call<GetAccountResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun saveUserData(context: Context, accountBalance:String, username:String ) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("accountBalance", accountBalance)
        editor.putString("username", username)
        editor.apply()
    }

    fun getAccessToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        return sharedPreferences.getString("ACCESS_TOKEN", null)
    }
}
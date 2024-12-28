package com.example.wallet5.Login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet5.MainActivity
import com.example.wallet5.R
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.SignUp.Signup_Activity
import com.example.wallet5.model.request.Login
import com.example.wallet5.model.response.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.edtPassWord
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login_Activity : AppCompatActivity() {
    private var UserLogin :List<Login> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        btnSignIn.setOnClickListener {
            if (edtUserName.text.isEmpty() || edtPassWord.text.isEmpty()) {
                Toast.makeText(this, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                edtUserName.requestFocus()
            }
            postUserLogin()



        }
        txtSignUp.setOnClickListener{
            val i1 = Intent(applicationContext, Signup_Activity::class.java)
            startActivity(i1)

        }

    }


    fun saveAccessToken(context: Context, token: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("ACCESS_TOKEN", token)
        editor.apply()
    }

    private fun postUserLogin() {
        val userName = edtUserName.text.toString()
        val passWord = edtPassWord.text.toString()
        val body = Login(userName, passWord)
        RetrofitClient.getRetrofitLogin().getLogins(body).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                if (response.body()?.code == 200) {
                    saveAccessToken(applicationContext, response.body()?.result?.accessToken.toString())
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(applicationContext, "Bạn đã nhập sai, Mời nhập lại", Toast.LENGTH_SHORT).show()
                }
            }


            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()

            }

        })
    }
}
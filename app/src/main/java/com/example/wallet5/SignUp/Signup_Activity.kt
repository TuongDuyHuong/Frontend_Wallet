package com.example.wallet5.SignUp

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet5.Login.Login_Activity
import com.example.wallet5.R
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.model.request.Register
import com.example.wallet5.model.response.RegisterResponse
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.edtPassWord
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)



        imgSignIn.setOnClickListener {
            if (edtUserNameSignUp.text.isEmpty() || edtPassWord.text.isEmpty() || edtEmail.text.isEmpty()
                || edtFirstName.text.isEmpty() || edtLastName.text.isEmpty() || edtPhoneNumber.text.isEmpty() ) {
                Toast.makeText(this, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                edtUserNameSignUp.requestFocus()
            }
            btnRegisterClick()


        }
        txtSignIn.setOnClickListener {
            val intent2 = Intent(this, Login_Activity::class.java)
            startActivity(intent2)
        }
    }

//    private fun saveUserData() {
//        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putString("username", edtUserNameSignUp.text.toString())
//        editor.putString("email", edtEmail.text.toString())
//        editor.putString("phonenumber",edtPhoneNumber.text.toString())
//        editor.putString("edtpassword",edtPassWord.text.toString())
//        editor.apply()
//    }


    private fun btnRegisterClick() {
        val post= Register(edtUserNameSignUp.text.toString(), edtPassWord.text.toString(), edtEmail.text.toString(),
        edtFirstName.text.toString(), edtLastName.text.toString(), edtPhoneNumber.text.toString())
        RetrofitClient.postRegister().postRegisters(post).enqueue(object: Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.body()?.code == 409) {
                    Toast.makeText(applicationContext, "Ban da nhap sai", Toast.LENGTH_SHORT ).show()

                }
                val intent = Intent(applicationContext, Login_Activity::class.java)
                startActivity(intent)
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT ).show()
            }

        })
    }
}
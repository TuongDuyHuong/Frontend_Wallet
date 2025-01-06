package com.example.wallet5.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.wallet5.R
import com.example.wallet5.Recharge_Activity
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.RetrofitClient.RetrofitClient.getAccount
import com.example.wallet5.Tranfer.Tranfer_Activity
import com.example.wallet5.UserBank_Activity
import com.example.wallet5.model.response.GetAccountResponse
import kotlinx.android.synthetic.main.fragment_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_menu.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_menu : Fragment(R.layout.fragment_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         getAccounts()
        txtBalanceWallet.text = context?.let { getAccountBalance(it) }
        txtNameUser.text = context?.let { getNameUser(it) }

        btnMoney.setOnClickListener{
            val intent1 = Intent(context, Recharge_Activity::class.java)
            startActivity(intent1)


        }
        btnTranfer.setOnClickListener{
            val intent2 = Intent(context, Tranfer_Activity::class.java)
            startActivity(intent2)

        }
        val subQR = fragment_scanqr()

        btnBank.setOnClickListener{
            val intent3 = Intent(context, UserBank_Activity::class.java)
            startActivity(intent3)

        }

    }

    private fun getAccountBalance(context: Context):String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
        return sharedPreferences.getString("accountBalance",null)
    }
    private fun getNameUser(context: Context):String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
        return sharedPreferences.getString("username",null)
    }



    fun getAccounts() {
        val token ="Bearer "+ context?.let { getAccessToken(it).toString() }

        RetrofitClient.getAccount().getAccounts(token).enqueue(object: Callback<GetAccountResponse>{
            override fun onResponse(
                call: Call<GetAccountResponse>,
                response: Response<GetAccountResponse>,
            ) {
                if (response.body()?.code == 200) {

                    txtBalanceWallet?.text = response.body()!!.result.accountBalance
                    txtNameUser.text = response.body()!!.result.username
                }
            }

            override fun onFailure(call: Call<GetAccountResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getAccessToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        return sharedPreferences.getString("ACCESS_TOKEN", null)
    }
}
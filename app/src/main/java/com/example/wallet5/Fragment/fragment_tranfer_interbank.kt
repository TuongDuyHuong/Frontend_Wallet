package com.example.wallet5.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.wallet5.R
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.Tranfer.Tranferred_Activity
import com.example.wallet5.model.UserData
import com.example.wallet5.model.request.PreTranfer
import com.example.wallet5.model.request.Tranfer
import com.example.wallet5.model.response.CheckOtpResponse
import com.example.wallet5.model.response.PreTranfer.OtpResponse
import com.example.wallet5.model.response.PreTranfer.Result_PreTranfer
import com.example.wallet5.model.response.PreTranferResponse
import com.example.wallet5.model.response.TranferResponse
import kotlinx.android.synthetic.main.fragment_tranfer_interbank.*
import kotlinx.android.synthetic.main.otp_dialog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_tranfer_interbank.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_tranfer_interbank : Fragment(R.layout.fragment_tranfer_interbank) {
    lateinit var dialog : AlertDialog
    lateinit var resultPreTranfer :Result_PreTranfer
    lateinit var otp:String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNextToOTP = view.findViewById<Button>(R.id.btnNextToOTP)
        btnNextToOTP.setOnClickListener {
            callApiPreTranfer()


        }
    }

    private fun callApiPreTranfer() {

        val type = "0"
        val bankCode = edtNameBank.text.toString()
        val accountNumber = edtAccountBank.text.toString()
        val amount = edtAmount.text.toString()
        val body =PreTranfer(type, bankCode,accountNumber,amount)
        val token ="Bearer "+ context?.let { it1 -> getAccessToken(it1).toString() }
        RetrofitClient.postPreTranfer().postPreTranfers(body,token).enqueue(object:Callback<PreTranferResponse> {
            override fun onResponse(
                call: Call<PreTranferResponse>,
                response: Response<PreTranferResponse>,
            ) {
                if (response.body()?.code ==200) {
                    resultPreTranfer = response.body()!!.result
                    sentOtp()
                    showDialogOTP()
                }
                else {
                    Toast.makeText(context, "Ban da nhập sai, mời nhập lại", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PreTranferResponse>, t: Throwable) {

            }
        })
    }

    private fun showDialogOTP() {
        val build = context?.let { AlertDialog.Builder(it) }
        val view  = layoutInflater.inflate(R.layout.otp_dialog, null)
        build?.setView(view)

        val btnCloseDialog= view.findViewById<ImageButton>(R.id.btnCloseDialog)
        btnCloseDialog.setOnClickListener {
            dialog.dismiss()
        }
        val btnBackTranfer = view.findViewById<Button>(R.id.btnBackTranfer)
        btnBackTranfer.setOnClickListener { dialog.dismiss() }
        val btnNextToTranfer = view.findViewById<Button>(R.id.btnNextToTranfer)
        btnNextToTranfer.setOnClickListener {
            val edtOtp = view.findViewById<EditText>(R.id.edtOTP)
            otp = edtOtp.text.toString()
            val token ="Bearer "+ context?.let { it1 -> getAccessToken(it1).toString() }
            RetrofitClient.postCheckOtp().postCheckOtps(otp,token).enqueue(object: Callback<CheckOtpResponse> {
                override fun onResponse(
                    call: Call<CheckOtpResponse>,
                    response: Response<CheckOtpResponse>,
                ) {
                    if ( response.body()?.result == true){
                        Toast.makeText(context, "Thành công", Toast.LENGTH_SHORT).show()
                        callApiTranfer()

                    }
                    else{
                        Toast.makeText(context, "Bạn đã nhập sai, mời nhập lại", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<CheckOtpResponse>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }
            })



        }
        dialog =  build!!.create()
        dialog.show()
    }

    private fun callApiTranfer() {
        val body = Tranfer(otp,resultPreTranfer.userFrom, resultPreTranfer.amount,resultPreTranfer.nameTo,resultPreTranfer.numberFrom,
            resultPreTranfer.numberTo, resultPreTranfer.type, resultPreTranfer.userTo)
        val token ="Bearer "+ context?.let { it1 -> getAccessToken(it1).toString() }
        RetrofitClient.postTranfer().postTranfers(body, token).enqueue(object : Callback<TranferResponse> {
            override fun onResponse(
                call: Call<TranferResponse>,
                response: Response<TranferResponse>,
            ) {
                if (response.body()?.code == 200) {
                    dialog.dismiss()
                    val edtMess = view?.findViewById<EditText>(R.id.edtContentTranfer)
                    val i = Intent(context, Tranferred_Activity::class.java)
                    val bundle = Bundle()
                    bundle.putString("amount", resultPreTranfer.amount.toString())
                    bundle.putString("nameto", resultPreTranfer.nameTo)
                    bundle.putString("numberaccount", resultPreTranfer.userTo.numberAccount)
                    bundle.putString("contenttranfer", edtMess?.text.toString())
                    i.putExtras(bundle)

                    startActivity(i)

                }
            }

            override fun onFailure(call: Call<TranferResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun sentOtp() {

        val token ="Bearer "+ context?.let { it1 -> getAccessToken(it1).toString() }
        val phoneNumber = resultPreTranfer.numberFrom
        RetrofitClient.getOtp().getOtps(phoneNumber, token).enqueue(object :Callback<List<OtpResponse>> {
            override fun onResponse(
                call: Call<List<OtpResponse>>,
                response: Response<List<OtpResponse>>,
            ) {

            }

            override fun onFailure(call: Call<List<OtpResponse>>, t: Throwable) {

            }
        })
    }

    fun getAccessToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        return sharedPreferences.getString("ACCESS_TOKEN", null)
    }
//    private fun getUserData(): UserData {
//        val sharedPreferences = context!!.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
//        val username = sharedPreferences.getString("username", String())
//        val email = sharedPreferences.getString("email", String())
//        val phonenumber = sharedPreferences.getString("phonenumber", String())
//        val edtpassword = sharedPreferences.getString("edtpassword", String())
//
//        return UserData(username, email, phonenumber, edtpassword)
//    }
}
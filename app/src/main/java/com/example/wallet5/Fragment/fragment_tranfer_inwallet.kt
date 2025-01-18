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
import com.example.wallet5.model.request.PreTranfer
import com.example.wallet5.model.request.PreTranferWallet
import com.example.wallet5.model.request.Tranfer
import com.example.wallet5.model.request.TranferWallet
import com.example.wallet5.model.response.CheckOtpResponse
import com.example.wallet5.model.response.PreResponseWallet
import com.example.wallet5.model.response.PreTranfer.OtpResponse
import com.example.wallet5.model.response.PreTranfer.Result_PreTranfer
import com.example.wallet5.model.response.PreTranferResponse
import com.example.wallet5.model.response.PreWallet.Result_PreWallet
import com.example.wallet5.model.response.TranferResponse
import kotlinx.android.synthetic.main.fragment_tranfer_interbank.*
import kotlinx.android.synthetic.main.fragment_tranfer_inwallet.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_tranfer_inwallet.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_tranfer_inwallet : Fragment(R.layout.fragment_tranfer_inwallet) {
    lateinit var dialog : AlertDialog
    lateinit var resultPreTranfer : Result_PreWallet
    lateinit var otp:String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (context?.let { getbankAccount(it) } != null) {
            val edtAccountBank = view.findViewById<EditText>(R.id.edtAccountBankWallet)
            edtAccountBank.setText(context?.let { getbankAccount(it) })
            val edtContentTranfer = view.findViewById<EditText>(R.id.edtContentTranferWallet)
            edtContentTranfer.setText(context?.let { getContent(it) })

        }
        val btnNextToOTP = view.findViewById<Button>(R.id.btnNextToOTPWallet)
        btnNextToOTP.setOnClickListener {
            callApiPreTranfer()

        }

    }
    fun getbankAccount(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("inforQR", Context.MODE_PRIVATE)
        return sharedPreferences.getString("bankAccount", null)
    }
    fun getType(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("inforQR", Context.MODE_PRIVATE)
        return sharedPreferences.getString("type", null)
    }
    fun getContent(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("inforQR", Context.MODE_PRIVATE)
        return sharedPreferences.getString("content", null)
    }
    private fun callApiPreTranfer() {

        val type = "0"
        val edtAccountBank = view?.findViewById<EditText>(R.id.edtAccountBankWallet)
        val accountNumber = edtAccountBank?.text.toString()
        val edtAmount = view?.findViewById<EditText>(R.id.edtAmountWallet)
        val amount = edtAmount?.text.toString()
        val body = PreTranferWallet(type,accountNumber,amount)
        val token ="Bearer "+ context?.let { it1 -> getAccessToken(it1).toString() }
        RetrofitClient.postPreWallet().postPreWallets(body,token).enqueue(object:
            Callback<PreResponseWallet> {
            override fun onResponse(
                call: Call<PreResponseWallet>,
                response: Response<PreResponseWallet>,
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

            override fun onFailure(call: Call<PreResponseWallet>, t: Throwable) {

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
            if (edtOtp.text.toString()==null)
                Toast.makeText(context, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
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
        val body = TranferWallet(otp,resultPreTranfer.userFrom, resultPreTranfer.amount,resultPreTranfer.nameTo,resultPreTranfer.numberFrom,
            resultPreTranfer.userToW, resultPreTranfer.numberTo, resultPreTranfer.type)
        val token ="Bearer "+ context?.let { it1 -> getAccessToken(it1).toString() }
        RetrofitClient.postTranferWallet().postTranferWallets(body, token).enqueue(object : Callback<TranferResponse> {
            override fun onResponse(
                call: Call<TranferResponse>,
                response: Response<TranferResponse>,
            ) {
                if (response.body()?.code == 200) {
                    dialog.dismiss()
                    val edtMess = view?.findViewById<EditText>(R.id.edtContentTranferWallet)
                    val i = Intent(context, Tranferred_Activity::class.java)
                    val bundle = Bundle()
                    bundle.putString("amount", resultPreTranfer.amount.toString())
                    bundle.putString("nameto", resultPreTranfer.nameTo)
                    bundle.putString("numberaccount", resultPreTranfer.numberTo)
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
}
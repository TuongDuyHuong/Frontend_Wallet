package com.example.wallet5

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.wallet5.Adapter.CustomAdapterSpBank
import com.example.wallet5.Adapter.List_Bank_Adapter
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.model.Result_Bank
import com.example.wallet5.model.request.Bank
import com.example.wallet5.model.request.InforBank
import com.example.wallet5.model.response.BankResponse
import com.example.wallet5.model.response.Bank_Connected
import com.example.wallet5.model.response.DeleteBankResponse
//import kotlinx.android.synthetic.main.activity_connect_bank.*
import kotlinx.android.synthetic.main.activity_user_bank.*
import kotlinx.android.synthetic.main.form_bank_dialog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserBank_Activity : AppCompatActivity() {
    lateinit var dialog : AlertDialog
    lateinit var customBankAdapter: List_Bank_Adapter
    lateinit var listBankUser:List<Result_Bank>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_bank)
        btnAddBank.setOnClickListener{
            showDialogBank()

        }
        addList()
        btnCloseListBank.setOnClickListener {
            val intent1 = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent1)
        }

        lvBank.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i1, l ->
            val deleteDialog = AlertDialog.Builder(this)
            deleteDialog.apply {
                setTitle("Hủy liên kết")
                setMessage("Bạn có muốn hủy liên kết ngân hàng này?")
                setNegativeButton("Không"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                setPositiveButton("Có"){ dialogInterface: DialogInterface, i: Int ->
                    val id = listBankUser[i1].id.toString().toInt()
                    val token ="Bearer "+getAccessToken(applicationContext).toString()
                    RetrofitClient.deleteBankUser().deleteBankUsers(id,token).enqueue(object: Callback<DeleteBankResponse> {
                        override fun onResponse(
                            call: Call<DeleteBankResponse>,
                            response: Response<DeleteBankResponse>,
                        ) {
                            if (response.body()?.code == 200){
                                Toast.makeText(applicationContext, "Thành Công", Toast.LENGTH_SHORT).show()
                                addList()
                            }
                        }

                        override fun onFailure(call: Call<DeleteBankResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            }
            deleteDialog.show()
        })


    }

    private fun addList() {
        val token ="Bearer "+getAccessToken(applicationContext).toString()
        RetrofitClient.postBankUser().postBankUsers(token).enqueue(object: Callback<Bank_Connected> {
            override fun onResponse(call: Call<Bank_Connected>, response: Response<Bank_Connected>) {
                listBankUser = response.body()?.result!!
                if (listBankUser != null) {
                    customBankAdapter =List_Bank_Adapter(this@UserBank_Activity, listBankUser)
                    val lvBank = findViewById<ListView>(R.id.lvBank)
                    lvBank.adapter = customBankAdapter
                }


            }

            override fun onFailure(call: Call<Bank_Connected>, t: Throwable) {

            }
        })
    }

    fun getAccessToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        return sharedPreferences.getString("ACCESS_TOKEN", null)
    }

    private fun showDialogBank() {
        val build = AlertDialog.Builder(this)
        val view  = layoutInflater.inflate(R.layout.form_bank_dialog, null)
        build.setView(view)
        dialog =  build.create()
        dialog.show()
        val btnBackTranfers = view.findViewById<Button>(R.id.btnBackTranfer)
        btnBackTranfers.setOnClickListener { dialog.dismiss() }
        val btnNextToTranfer = view.findViewById<Button>(R.id.btnNextToTranfers)
        btnNextToTranfer.setOnClickListener {
            val edtNumberBank = view.findViewById<EditText>(R.id.edtNumberBank)
            val edtBank = view.findViewById<EditText>(R.id.edtBank)
            val edtPhoneNumberBank = view.findViewById<EditText>(R.id.edtPhoneNumberBank)
            val edtBalance = view.findViewById<EditText>(R.id.edtBalance)

            val inforBank = listOf<InforBank>(InforBank(edtNumberBank.text.toString(), edtBank.text.toString(),edtBalance.text.toString() ))
            val body =  Bank(edtPhoneNumberBank.text.toString(),inforBank)
            var token ="Bearer "+getAccessToken(applicationContext).toString()
            RetrofitClient.postBankUser().postBank(body,token ).enqueue(object : Callback<BankResponse> {
                override fun onResponse(
                    call: Call<BankResponse>,
                    response: Response<BankResponse>,
                ) {
                    if (response.body()?.code != 201) {
                        Toast.makeText(applicationContext, "Bạn đã nhập sai, Mời nhập lại", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Thành Công", Toast.LENGTH_SHORT).show()
                        addList()
                        dialog.dismiss()
                    }

                }

                override fun onFailure(call: Call<BankResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }

            })



        }

    }




}
package com.example.wallet5.Fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.wallet5.Adapter.List_Bank_Adapter
import com.example.wallet5.R
import com.example.wallet5.Recharge_Activity
import com.example.wallet5.Recharged_Activity
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.model.Result_Bank
import com.example.wallet5.model.response.Bank_Connected
import com.example.wallet5.model.response.RechargeResponse
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.*
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.btn1000d
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.btn100d
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.btn2000d
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.btn200d
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.btn500d
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.btn50d
import kotlinx.android.synthetic.main.fragment_fragment_recharge2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentmenu2.newInstance] factory method to
 * create an instance of this fragment.
 */
 class fragmentmenu2 : Fragment(R.layout.fragment_fragment_recharge2) {
    lateinit var customBankAdapter: List_Bank_Adapter
    lateinit var listBankUser: List<Result_Bank>
    lateinit var bankConnected: Bank_Connected

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn50d = view.findViewById<Button>(R.id.btn50d)
        btn50d.setOnClickListener {
            edtMoney.setText("50000")
        }
        val btn100d = view.findViewById<Button>(R.id.btn100d)
        btn100d.setOnClickListener {
            edtMoney.setText("100000")
        }
        val btn200d = view.findViewById<Button>(R.id.btn200d)
        btn200d.setOnClickListener {
            edtMoney.setText("200000")
        }
        val btn500d = view.findViewById<Button>(R.id.btn500d)
        btn500d.setOnClickListener {
            edtMoney.setText("500000")
        }
        val btn1000d = view.findViewById<Button>(R.id.btn1000d)
        btn1000d.setOnClickListener {
            edtMoney.setText("1000000")
        }
        val btn2000d = view.findViewById<Button>(R.id.btn2000d)
        btn2000d.setOnClickListener {
            edtMoney.setText("2000000")
        }
        addLists()
        setupSpinner()


    }

    private fun setupSpinner() {
        val spBank_Recharge = view?.findViewById<Spinner>(R.id.spBank_Recharge)
        spBank_Recharge?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                val btnRecharge = view?.findViewById<Button>(R.id.btnRecharge)
                btnRecharge?.setOnClickListener {
                    recharge(p2)
                    val edtAmount = view?.findViewById<EditText>(R.id.edtAmount)
                    edtAmount?.setText("")
                    edtAmount?.requestFocus()

                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    private fun recharge(index:Int) {
        val token ="Bearer "+ context?.let { getAccessToken(it).toString() }
        val id = bankConnected.result[index].id.toInt()
        val edtAmount = view?.findViewById<EditText>(R.id.edtAmount)
        val amount = edtAmount?.text.toString()
        RetrofitClient.postRecharge().postRecharges(id, amount, token).enqueue(object :Callback<RechargeResponse>{
            override fun onResponse(
                call: Call<RechargeResponse>,
                response: Response<RechargeResponse>,
            ) {
                if(response.body()?.code==200) {
                    val i = Intent(context, Recharged_Activity::class.java)
                    i.putExtra("amount", amount)
                    startActivity(i)
                }
                else{
                    Toast.makeText(context, "Bạn đã nhập sai, mời nhập lại", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RechargeResponse>, t: Throwable) {

            }
        })
    }

    private fun addLists() {
        val token ="Bearer "+ context?.let { getAccessToken(it).toString() }
        RetrofitClient.postBankUser().postBankUsers(token).enqueue(object:
            Callback<Bank_Connected> {
            override fun onResponse(call: Call<Bank_Connected>, response: Response<Bank_Connected>) {
                listBankUser = response.body()?.result!!
                if (listBankUser != null) {
                    customBankAdapter =List_Bank_Adapter(requireActivity(), listBankUser)
                    val spBankRecharge = view?.findViewById<Spinner>(R.id.spBank_Recharge)
                    spBankRecharge?.adapter = customBankAdapter
                    bankConnected = response.body()!!
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
}

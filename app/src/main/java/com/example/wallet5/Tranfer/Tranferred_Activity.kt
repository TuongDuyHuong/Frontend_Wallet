package com.example.wallet5.Tranfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wallet5.MainActivity
import com.example.wallet5.R
import kotlinx.android.synthetic.main.activity_tranferred.*

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
            val i2 = Intent(this, MainActivity::class.java)
            startActivity(i2)
        }
    }
}
package com.example.wallet5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recharged.*

class Recharged_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharged)
        btnBackHome.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        btnGoOn.setOnClickListener {
            val i2 = Intent(this, Recharge_Activity::class.java)
            startActivity(i2)
        }
        val i = intent
        txtAmountRecharge.text =  i.getStringExtra("amount")
    }
}
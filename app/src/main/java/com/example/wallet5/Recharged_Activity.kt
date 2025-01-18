package com.example.wallet5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_recharged.*
import java.text.SimpleDateFormat
import java.util.*

class Recharged_Activity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharged)
        val cal = Calendar.getInstance()
        val date = cal.time

        val time = SimpleDateFormat("hh:mm:ss a - dd/MM/yyyy")
        val txtTimeOfTranfers = findViewById<TextView>(R.id.txtTimeOfTranfers)
        txtTimeOfTranfers.text = time.format(date)
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
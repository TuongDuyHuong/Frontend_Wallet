package com.example.wallet5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tranfer_infor.*

class TranferInfor_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranfer_infor)

        btnBackMenuTranfer.setOnClickListener {
            val intent = Intent(this, Tranfer_Activity::class.java)
            startActivity(intent)
        }
    }
}
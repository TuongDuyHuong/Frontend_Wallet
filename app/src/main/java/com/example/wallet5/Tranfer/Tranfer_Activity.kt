package com.example.wallet5.Tranfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wallet5.MainActivity
import com.example.wallet5.R
import kotlinx.android.synthetic.main.activity_tranfer.*

class Tranfer_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranfer)
        btnBackMenu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        txtSoTaiKhoan.setOnClickListener {
            val intent2 = Intent(this, TranferInfor_Activity::class.java)
            startActivity(intent2)
        }
    }
}
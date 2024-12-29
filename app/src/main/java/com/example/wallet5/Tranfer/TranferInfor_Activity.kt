package com.example.wallet5.Tranfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.wallet5.Adapter.PagerAdapterTranfer
import com.example.wallet5.Adapter.ViewPagerAdapter
import com.example.wallet5.MainActivity
import com.example.wallet5.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_recharge.*
import kotlinx.android.synthetic.main.activity_tranfer_infor.*


class TranferInfor_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranfer_infor)

        val adapter = PagerAdapterTranfer(supportFragmentManager,lifecycle)
        pagerMenuTranfer.adapter = adapter

        TabLayoutMediator(tabMenuTrafer, pagerMenuTranfer) {tab, pos->
            when(pos){
                0 -> {tab.text= "Ngân Hàng"}
                else -> {tab.text= "Ví điện tử"}
            }
        }.attach()

        btnBackTranfer.setOnClickListener {
            val intent = Intent(this, Tranfer_Activity::class.java)
            startActivity(intent)
        }

    }


}
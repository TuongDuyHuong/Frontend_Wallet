package com.example.wallet5

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_recharge.*

class Recharge_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge)
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        pagermenu.adapter = adapter

        TabLayoutMediator(tabmenu, pagermenu) {tab, pos->
            when(pos){
                0 -> {tab.text= "Nạp Tiền"}
                else -> {tab.text= "Rút Tiền"}
            }
        }.attach()

        btnBackMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.wallet5

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet5.Adapter.ViewPagerAdapterMenu
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapterMenu(supportFragmentManager,lifecycle)
        pagermain.adapter = adapter

        TabLayoutMediator(tabmain,pagermain) {tab, pos ->
            when(pos){
                0 -> {tab.text = "Menu"}
                1 -> {tab.text = "Ưu đãi"}
                2 -> {tab.text = "Quét QR"}
                3 -> {tab.text = "Lịch sử GD"}
                else -> {tab.text = "Tôi"}
            }
        }.attach()

    }
}
package com.example.wallet5.Tranfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.wallet5.R
import kotlinx.android.synthetic.main.activity_tranfer_infor.btnBackMenuTranfer
import kotlinx.android.synthetic.main.activity_tranfer_infor.btnNextToOTP

class TranferInfor_Activity : AppCompatActivity() {
    lateinit var dialog : AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranfer_infor)

        btnBackMenuTranfer.setOnClickListener {
            val intent = Intent(this, Tranfer_Activity::class.java)
            startActivity(intent)
        }
        btnNextToOTP.setOnClickListener {
            showDialogOTP()
        }
    }

    private fun showDialogOTP() {
        val build = AlertDialog.Builder(this)
        val view  = layoutInflater.inflate(R.layout.otp_dialog, null)
        build.setView(view)
        val btnCloseDialog= view.findViewById<ImageButton>(R.id.btnCloseDialog)
        btnCloseDialog.setOnClickListener {
            dialog.dismiss()
        }
        val btnBackTranfer = view.findViewById<Button>(R.id.btnBackTranfer)
        btnBackTranfer.setOnClickListener { dialog.dismiss() }
        val btnNextToTranfer = view.findViewById<Button>(R.id.btnNextToTranfer)
        btnNextToTranfer.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, Tranferred_Activity::class.java)
            startActivity(intent)

        }
        dialog =  build.create()
        dialog.show()
    }
}
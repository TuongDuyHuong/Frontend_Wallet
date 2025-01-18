package com.example.wallet5


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallet5.Fragment.fragment_profile
import com.example.wallet5.Fragment.fragment_scanqr
import com.example.wallet5.RetrofitClient.RetrofitClient
import com.example.wallet5.model.response.GetAccountResponse
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_user_qr.*
import net.glxn.qrgen.android.QRCode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class User_QR_Activity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_qr)

        btnBackss.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        val qrCodeImageView: ImageView = findViewById(R.id.qrCodeImageView)

        // Thông tin chuyển tiền
        val token ="Bearer "+getAccessToken(applicationContext).toString()
        RetrofitClient.getAccount().getAccounts(token).enqueue(object :Callback<GetAccountResponse>{
            override fun onResponse(
                call: Call<GetAccountResponse>,
                response: Response<GetAccountResponse>,
            ) {
                if (response.body()?.code==200) {
                    val bankAccount = response.body()?.result?.phoneNumber
                    val type = "1"
                    val content = "Chuyen tien"
                    val qrData = "banktransfer://$bankAccount?type=$type&content=$content"

                    // Tạo mã QR
                    val bitmap: Bitmap = QRCode.from(qrData).bitmap()
                    qrCodeImageView.setImageBitmap(bitmap)
                }
            }

            override fun onFailure(call: Call<GetAccountResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })


    }
    fun getAccessToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        return sharedPreferences.getString("ACCESS_TOKEN", null)
    }

}
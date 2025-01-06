package com.example.wallet5.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.example.wallet5.R
import com.example.wallet5.Tranfer.TranferInfor_Activity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_scanqr.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_scanqr : Fragment(R.layout.fragment_scanqr) {
    private lateinit var codeScanner: CodeScanner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_scanqr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()
        codeScanner = CodeScanner(activity, scannerView)
        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                val qrData = it.text
                val uri = Uri.parse(qrData)
                val bankAccount = uri.host.toString()
                val type = uri.getQueryParameter("type").toString()
                val content = uri.getQueryParameter("content").toString()
                context?.let { it1 -> saveInforQr(it1, bankAccount,type,content) }
                val i = Intent(context,TranferInfor_Activity::class.java )

                startActivity(i)

            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }
    private fun saveInforQr(context: Context, bankAccount:String, type:String,content:String  ) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("inforQR", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("bankAccount", bankAccount)
        editor.putString("type", type)
        editor.putString("content", content)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}
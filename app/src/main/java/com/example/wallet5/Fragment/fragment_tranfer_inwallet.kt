package com.example.wallet5.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.wallet5.R
import com.example.wallet5.Tranfer.Tranferred_Activity
import kotlinx.android.synthetic.main.fragment_tranfer_inwallet.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_tranfer_inwallet.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_tranfer_inwallet : Fragment(R.layout.fragment_tranfer_inwallet) {
    lateinit var dialog : AlertDialog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNextToOTP.setOnClickListener {
            showDialogOTP()
        }
    }
    private fun showDialogOTP() {
        val build = context?.let { AlertDialog.Builder(it) }
        val view  = layoutInflater.inflate(R.layout.otp_dialog, null)
        build?.setView(view)
        val btnCloseDialog= view.findViewById<ImageButton>(R.id.btnCloseDialog)
        btnCloseDialog.setOnClickListener {
            dialog.dismiss()
        }
        val btnBackTranfer = view.findViewById<Button>(R.id.btnBackTranfer)
        btnBackTranfer.setOnClickListener { dialog.dismiss() }
        val btnNextToTranfer = view.findViewById<Button>(R.id.btnNextToTranfer)
        btnNextToTranfer.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(context, Tranferred_Activity::class.java)
            startActivity(intent)

        }
        dialog =  build!!.create()
        dialog.show()
    }
}
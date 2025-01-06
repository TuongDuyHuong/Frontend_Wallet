package com.example.wallet5.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.example.wallet5.Login.Login_Activity
import com.example.wallet5.R
import com.example.wallet5.User_QR_Activity
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_profile : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnLogOut = view.findViewById<Button>(R.id.btnLogOut)
        btnLogOut.setOnClickListener {
            val i = Intent(context, Login_Activity::class.java)
            startActivity(i)
        }
        val btnUserQr = view.findViewById<Button>(R.id.btnUserQr)
        btnUserQr.setOnClickListener {
            val i2 = Intent(context, User_QR_Activity::class.java)
            startActivity(i2)
        }
    }
}
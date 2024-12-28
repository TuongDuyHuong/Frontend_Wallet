package com.example.wallet5.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.wallet5.R
import com.example.wallet5.Recharge_Activity
import com.example.wallet5.Tranfer.Tranfer_Activity
import com.example.wallet5.UserBank_Activity
import kotlinx.android.synthetic.main.fragment_menu.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_menu.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_menu : Fragment(R.layout.fragment_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMoney.setOnClickListener{
            val intent1 = Intent(context, Recharge_Activity::class.java)
            startActivity(intent1)

        }
        btnTranfer.setOnClickListener{
            val intent2 = Intent(context, Tranfer_Activity::class.java)
            startActivity(intent2)

        }
        val subQR = fragment_scanqr()

        btnBank.setOnClickListener{
            val intent3 = Intent(context, UserBank_Activity::class.java)
            startActivity(intent3)

        }

    }
}
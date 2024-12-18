package com.example.wallet5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fragment_recharge1.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentmenu1.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentmenu1 : Fragment(R.layout.fragment_fragment_recharge1) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn50d.setOnClickListener {
            edtMoney.setText("50000")
        }
        btn100d.setOnClickListener {
            edtMoney.setText("100000")
        }
        btn200d.setOnClickListener {
            edtMoney.setText("200000")
        }
        btn500d.setOnClickListener {
            edtMoney.setText("500000")
        }
        btn1000d.setOnClickListener {
            edtMoney.setText("1000000")
        }
        btn2000d.setOnClickListener {
            edtMoney.setText("2000000")
        }
    }
}

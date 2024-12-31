package com.example.wallet5.Adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.wallet5.R
import com.example.wallet5.model.Result_Bank
import com.example.wallet5.model.response.Bank_Connected

class List_Bank_Adapter(val activity: Activity, val listresult:List<Result_Bank>) :ArrayAdapter<Result_Bank>(activity, R.layout.layout_userbank) {
    override fun getCount(): Int {
        return listresult.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.layout_userbank,parent, false )

        val txtNameBank = rowView.findViewById<TextView>(R.id.txtNameBank)
        val txtCode = rowView.findViewById<TextView>(R.id.txtCode)
        val txtBalance = rowView.findViewById<TextView>(R.id.txtBalance)
        val txtNumberBank = rowView.findViewById<TextView>(R.id.txtNumberBank)

        txtNameBank.text = listresult[position].bankName
        txtCode.text = listresult[position].code
        txtBalance.text = listresult[position].balance.toString()
        txtNumberBank.text = listresult[position].numberAccount

        return rowView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position,convertView,parent)
    }
}
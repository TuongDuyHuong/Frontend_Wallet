package com.example.wallet5.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.wallet5.OutdataBank
import com.example.wallet5.R

class CustomAdapterSpBank(val activity:Activity, val list: List<OutdataBank>):ArrayAdapter<OutdataBank>(activity, R.layout.layout_bank) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.layout_bank, parent, false)
        val code = rowView.findViewById<TextView>(R.id.txtCodes)
        val name = rowView.findViewById<TextView>(R.id.txtNames)
        code.text = list[position].code
        name.text = list[position].name
        return rowView
    }

}
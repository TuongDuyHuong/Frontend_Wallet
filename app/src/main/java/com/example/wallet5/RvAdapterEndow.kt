package com.example.wallet5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_endow_list.view.*

class RvAdapterEndow constructor(val ds:List<PhoTo>):RecyclerView.Adapter<RvAdapterEndow.EndowList>() {
    inner class EndowList (itemView: View) :RecyclerView.ViewHolder(itemView) {
        fun setData(phoTo: PhoTo) {

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EndowList {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_endow_list, parent, false)
        return EndowList(view)
    }

    override fun onBindViewHolder(holder: EndowList, position: Int) {
            holder.itemView.apply {
                txtTitle.text = ds[position].title
                txtMess.text = ds[position].url
            }
        }

    override fun getItemCount(): Int {
        return ds.size
    }
}


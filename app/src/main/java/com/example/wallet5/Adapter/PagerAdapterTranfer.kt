package com.example.wallet5.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wallet5.Fragment.fragment_tranfer_interbank
import com.example.wallet5.Fragment.fragment_tranfer_inwallet
import com.example.wallet5.Fragment.fragmentmenu1
import com.example.wallet5.Fragment.fragmentmenu2

class PagerAdapterTranfer(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 ->{
                fragment_tranfer_interbank()
            }
            else ->{
                fragment_tranfer_inwallet()
            }
        }
    }
}
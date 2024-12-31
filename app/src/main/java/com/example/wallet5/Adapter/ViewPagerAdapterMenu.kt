package com.example.wallet5.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wallet5.Fragment.*

class ViewPagerAdapterMenu(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {

                fragment_menu()
            }
            1 -> {
                fragment_endow()
            }
            2 -> {
                fragment_scanqr()
            }
            3 -> {
                fragment_transaction_history()
            }
            else -> {
                fragment_profile()
            }
        }
    }
}
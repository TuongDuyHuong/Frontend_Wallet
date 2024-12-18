package com.example.wallet5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_endow.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_endow.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_endow : Fragment(R.layout.fragment_endow) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var ds = listOf<PhoTo>()
        getPhoto()





        rvEndowList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
    private  fun getPhoto() {
        RetrofitClient.getRetrofitClient().getPhotos().enqueue(object: Callback<List<PhoTo>> {
            override fun onResponse(call: Call<List<PhoTo>>, response: Response<List<PhoTo>>) {
                val adapter =RvAdapterEndow(response.body()?: listOf())
                rvEndowList.adapter = adapter
            }

            override fun onFailure(call: Call<List<PhoTo>>, t: Throwable) {

            }
        })
    }
}
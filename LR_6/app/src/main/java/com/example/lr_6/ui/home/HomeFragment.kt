package com.example.lr_6.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.lr_6.API.Feelings
import com.example.lr_6.API.GetApi
import com.example.lr_6.API.MyRetrofit
import com.example.lr_6.API.Quotes
import com.example.lr_6.MyFeel
import com.example.lr_6.R
import com.example.lr_6.databinding.FragmentHomeBinding
import com.example.lr_6.recadapters.FeelRecycler
import com.example.lr_6.recadapters.StateRecycler
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val feelRecycler : RecyclerView = root.findViewById(R.id.rcViewHorizontal)

        val stateRecycler : RecyclerView = root.findViewById(R.id.rcViewVertival)

        val quotes = MyRetrofit().GetRetrofit()
        val apiRet = quotes.create(GetApi::class.java)
        val quotesCall: retrofit2.Call<Quotes> = apiRet.GetQuotes()
        quotesCall.enqueue(object : retrofit2.Callback<Quotes>{
            override fun onResponse(call: Call<Quotes>, response: Response<Quotes>) {
                if(response.isSuccessful){
                    stateRecycler.adapter = response.body()?.let { StateRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<Quotes>, t: Throwable) {

            }
        })

        val feelings = MyRetrofit().GetRetrofit()
        val apiRetFeel = feelings.create(GetApi::class.java)
        val feelingsCall : Call<Feelings> = apiRetFeel.GetFeel()
        feelingsCall.enqueue(object : retrofit2.Callback<Feelings>{
            override fun onResponse(call: Call<Feelings>, response: Response<Feelings>) {
                if(response.isSuccessful){
                    feelRecycler.adapter = response.body()?.let { FeelRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<Feelings>, t: Throwable) {

            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
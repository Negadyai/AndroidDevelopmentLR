package com.example.lr_4.ui.TrafficLightFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.lr_4.R

class TrafficLightFragment : Fragment() {

    companion object {
        fun newInstance() = TrafficLightFragment()
    }

    private lateinit var viewModel: TrafficLightViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_traffic_light, container, false)
        val redButton = view.findViewById<Button>(R.id.redButton)
        redButton.setOnClickListener {
            view.setBackgroundColor(resources.getColor(R.color.red))
            Toast.makeText(activity?.applicationContext, "Стой!", Toast.LENGTH_SHORT).show()
        }
        val yellowButton = view.findViewById<Button>(R.id.yellowButton)
        yellowButton.setOnClickListener {
            view.setBackgroundColor(resources.getColor(R.color.yellow))
            Toast.makeText(activity?.applicationContext, "Готовься!", Toast.LENGTH_SHORT).show()
        }
        val greenButton = view.findViewById<Button>(R.id.greenButton)
        greenButton.setOnClickListener {
            view.setBackgroundColor(resources.getColor(R.color.green))
            Toast.makeText(activity?.applicationContext, "Ехай!", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrafficLightViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
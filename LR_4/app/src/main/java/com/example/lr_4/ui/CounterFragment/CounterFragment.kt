package com.example.lr_4.ui.CounterFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.lr_4.R

class CounterFragment : Fragment() {

    companion object {
        fun newInstance() = CounterFragment()
    }

    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var crowCounter = 0
        var catCounter = 0

        val view = inflater.inflate(R.layout.fragment_counter, container, false)

        val crowCounterText = view.findViewById<TextView>(R.id.textCounterCrow)
        val catCounterText = view.findViewById<TextView>(R.id.textCounterCat)

        val catCounterButton = view.findViewById<Button>(R.id.catCounterButton)

        catCounterButton.setOnClickListener {
            catCounterText.text = "Я насчитал ${++catCounter} котов"

            if(crowCounter == catCounter * 2){
                catCounterText.text = "Я насчитал 0 котов"
                catCounter = 0
                Toast.makeText(activity?.applicationContext, "Коты убежали", Toast.LENGTH_SHORT).show()
            }

        }
        val crowCounterButton = view.findViewById<Button>(R.id.crowCounterButton)

        crowCounterButton.setOnClickListener {
            crowCounterText.text = "Я насчитал ${++crowCounter} ворон"

            if(crowCounter == catCounter){
                crowCounter = 0
                crowCounterText.text = "Я насчитал 0 ворон"
                Toast.makeText(activity?.applicationContext, "Вороны улетели", Toast.LENGTH_SHORT).show()
            }

        }
        return  view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
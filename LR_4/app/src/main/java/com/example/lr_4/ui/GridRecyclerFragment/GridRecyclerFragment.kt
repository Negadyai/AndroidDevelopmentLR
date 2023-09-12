package com.example.lr_4.ui.GridRecyclerFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lr_4.Photo
import com.example.lr_4.PhotoAdapter
import com.example.lr_4.R

class GridRecyclerFragment : Fragment() {

    companion object {
        fun newInstance() = GridRecyclerFragment()
    }

    private lateinit var viewModel: GridRecyclerViewModel
    lateinit var recyclerView : RecyclerView
    lateinit var addPhotoButton: Button

    private val adapter = PhotoAdapter()
    private val imageIdList = listOf(R.drawable.plant1, R.drawable.plant2, R.drawable.plant3, R.drawable.plant4, R.drawable.plant5)

    var index = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grid_recycler, container, false)
        recyclerView = view.findViewById<RecyclerView>(R.id.rcView)
        addPhotoButton = view.findViewById<Button>(R.id.addPhotoButton)
        Init()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GridRecyclerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun Init(){
        view.apply {
            recyclerView.layoutManager = GridLayoutManager(activity?.applicationContext, 3)
            recyclerView.adapter = adapter
            addPhotoButton.setOnClickListener{
                if(index > imageIdList.size - 1) index = 0

                val photo = Photo(imageIdList[index], "Plant $index")
                adapter.AddPhoto(photo)
                index++
            }
        }
    }

}
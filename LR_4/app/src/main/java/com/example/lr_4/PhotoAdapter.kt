package com.example.lr_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lr_4.databinding.PhotoItemBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    val photoList = ArrayList<Photo>()
    class PhotoHolder(item : View) : RecyclerView.ViewHolder(item) {
        val binding = PhotoItemBinding.bind(item)
        fun bind(photo: Photo){
            binding.im.setImageResource(photo.imageId)
            binding.tvTitle.text = photo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoHolder(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(photoList[position])
    }

    fun AddPhoto(photo: Photo){
        photoList.add(photo)
        notifyDataSetChanged()
    }
}
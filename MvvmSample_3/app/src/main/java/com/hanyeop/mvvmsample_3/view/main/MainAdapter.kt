package com.hanyeop.mvvmsample_3.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.mvvmsample_3.databinding.ItemLayoutBinding
import com.hanyeop.mvvmsample_3.model.Post

class MainAdapter
    : ListAdapter<Post, MainAdapter.ViewHolder>(diffUtil){

    inner class ViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        init {
            // TODO : 클릭리스너
        }
        fun bind(post: Post){
            binding.post = post
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<Post>(){
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}
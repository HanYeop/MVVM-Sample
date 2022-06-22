package com.hanyeop.mvvmsample_1.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.mvvmsample_1.databinding.ItemLayoutBinding
import com.hanyeop.mvvmsample_1.model.Post

class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    inner class MyViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                // TODO : 클릭 이벤트
            }
        }

        fun bind(position: Int){
            binding.post = myList[position]
        }
    }

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    // 뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return myList.size
    }

    // 데이터 변경시 리스트 다시 할당
    fun setData(newList : List<Post>){
        myList = newList
        // 새로고침
        notifyDataSetChanged()
    }
}
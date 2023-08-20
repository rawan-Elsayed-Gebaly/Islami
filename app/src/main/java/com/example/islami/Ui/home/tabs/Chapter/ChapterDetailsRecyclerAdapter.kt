package com.example.islami.Ui.home.tabs.Chapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.islami.databinding.SuraDetailsBinding
import com.example.islami.databinding.SuraRecyclerViewBinding

class ChapterDetailsRecyclerAdapter( val suraList :List<String>) :
    RecyclerView.Adapter<ChapterDetailsRecyclerAdapter.viewHolder>() {


    class viewHolder( val viewBinding: SuraRecyclerViewBinding)
        :RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding = SuraRecyclerViewBinding
            .inflate(LayoutInflater.from(parent.context), parent , false)

        return viewHolder(viewBinding)
    }

    override fun getItemCount(): Int = suraList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.suraContent.text = suraList[position]

    }
}


//var  position_i =-1
//var name:String = ""
//for (i in 1..114){
//    if(position == i )
//    {
//        position_i=i
//        name="${i}+txt"
//    }
//}
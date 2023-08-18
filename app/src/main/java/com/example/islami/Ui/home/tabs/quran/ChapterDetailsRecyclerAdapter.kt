package com.example.islami.Ui.home.tabs.quran

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.example.islami.R
import com.example.islami.databinding.SuraDetailsBinding
import java.io.IOException

class ChapterDetailsRecyclerAdapter(private val context:Context) :
    RecyclerView.Adapter<ChapterDetailsRecyclerAdapter.viewHolder>() {


    class viewHolder(val viewBinding: ViewBinding)
        :RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding = SuraDetailsBinding
            .inflate(LayoutInflater.from(parent.context), parent , false)

        return viewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {


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
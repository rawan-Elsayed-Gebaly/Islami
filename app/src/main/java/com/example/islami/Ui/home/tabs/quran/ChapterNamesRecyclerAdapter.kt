package com.example.islami.Ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterNameBinding

class ChapterNamesRecyclerAdapter( private  val chapterName:List<String>) : RecyclerView.Adapter<ChapterNamesRecyclerAdapter.viewHolder>() {

    class viewHolder (val viewBinding:ItemChapterNameBinding)
        :RecyclerView.ViewHolder(viewBinding.root)

     var onItemClickListener : onItmeClickListener?= null
  fun  interface onItmeClickListener {
        fun onClick (position:Int  , name :String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding = ItemChapterNameBinding
            .inflate(LayoutInflater.from(parent.context) , parent , false)
         return viewHolder(viewBinding)
    }

    override fun getItemCount(): Int =chapterName.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.title.text = chapterName[position]
        holder.viewBinding.root
            .setOnClickListener{
            onItemClickListener?.onClick(position , chapterName[position])
        }
    }

}
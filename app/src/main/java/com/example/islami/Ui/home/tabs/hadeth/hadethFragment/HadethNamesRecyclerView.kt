package com.example.islami.Ui.home.tabs.hadeth.hadethFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethNameBinding

class HadethNamesRecyclerView (private var hadethList: List<String>?) : RecyclerView.Adapter<HadethNamesRecyclerView.viewHolder>() {


    class viewHolder(val viewBinding : ItemHadethNameBinding)
        : RecyclerView.ViewHolder(viewBinding.root){

    }
    var onItemClickListener : onHadethItmeClickListener?= null

    fun  interface onHadethItmeClickListener {
        fun onClick (position:Int  , name :String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding = ItemHadethNameBinding
            .inflate(LayoutInflater.from(parent.context) , parent , false)
        return viewHolder(viewBinding)
    }

    override fun getItemCount(): Int = hadethList?.size ?:0

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.title.text = hadethList?.get(position) ?: ""
        holder.viewBinding.root
            .setOnClickListener{
                onItemClickListener?.onClick(position ,  hadethList?.get(position) ?: "" )
            }

    }

    fun bindItem(newList: List<String>){
        hadethList = newList
        notifyDataSetChanged()

    }


}
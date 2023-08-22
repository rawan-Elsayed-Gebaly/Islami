package com.example.islami.Ui.home.tabs.hadeth.hadethContent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.SuraRecyclerViewBinding

class HadethContentRecyclerAdapter (val hadethList: List<String>):
    RecyclerView.Adapter<HadethContentRecyclerAdapter.viewHolder>() {

class viewHolder(val viewBinding:SuraRecyclerViewBinding)
    :RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding = SuraRecyclerViewBinding
            .inflate(LayoutInflater.from(parent.context) , parent  , false)
        return viewHolder(viewBinding)
    }
    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.suraContent.text = hadethList[position]
    }

}
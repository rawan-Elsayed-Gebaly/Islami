package com.example.islami.Ui.home.tabs.hadeth.hadethFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Ui.Constants
import com.example.islami.Ui.home.tabs.hadeth.hadethContent.HadethContentActivity
import com.example.islami.Ui.model.HadethData
import com.example.islami.databinding.FragmentHadethBinding

class HadethFragment: Fragment() {
    lateinit var viewBinding:FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater , container , false)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerAdapter()
    }
    override fun onStart() {
        super.onStart()
        loadFiles()
       // loadHadeth()
        bindHadethList()
    }
    private fun bindHadethList() {
        adapter.bindItem(hadethTitleList)
    }
    val hadethTitleList = mutableListOf<String>()
    fun loadFiles() {
        val fileContent
                    = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {it.readText() }
         Constants.list_Of_Ahadeth = fileContent.trim().split("#")

        Constants.list_Of_Ahadeth.forEach { element->
           var firstLine= element.trim().lines().firstOrNull()?:""
            hadethTitleList.add(firstLine)
        }
        //  Log.d("isImpty" , Constants.ahadethNames.size.toString())
        // how can i get the first Line from String Text
        //  trim of the HadethName
        //  Add Ahadeth Names into An Array List
        //todo  Send Ahadeth Names to HadethNamesRecyclerAdapter
        //todo  Add hadeth Content to HadethContentActivity

    }
    val hadethList  = mutableListOf<HadethData>()
    fun loadHadeth(){
        val fileContent
                = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {it.readText() }
        val singleHadethList =fileContent.trim().split("#")
        singleHadethList.forEach { element->
            val lines = element.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString ("\n")
           val  hadeth = HadethData( title , content)
            hadethList.add(hadeth)
        }
    }
    lateinit var adapter: HadethNamesRecyclerView
    private fun initRecyclerAdapter() {
        adapter = HadethNamesRecyclerView(null)
        adapter.onItemClickListener =
            HadethNamesRecyclerView.onHadethItmeClickListener { position, name ->
                startHadethContentActivity( position  , name)
            }
         viewBinding.recyclerView.adapter = adapter
    }
    private fun startHadethContentActivity(position: Int, name: String) {
        val intent = Intent(context , HadethContentActivity::class.java)
        intent.putExtra(Constants.EXTRA_HADETH_INDEX , position)
        intent.putExtra(Constants.EXTRA_HADETH_NAME , name)
        startActivity(intent)
    }
}
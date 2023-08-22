package com.example.islami.Ui.home.tabs.Chapter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.Ui.Constants
import com.example.islami.Ui.home.HomeActivity
import com.example.islami.databinding.SuraDetailsBinding

class SuraDetailsActivity :AppCompatActivity (){

    lateinit var viewBinding : SuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewBinding = SuraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initParams()
        loadChapterFile()
        initSuraTitle()
        backArrow()
         }

    private fun backArrow() {
        viewBinding.backArrow.setOnClickListener{
            val intent = Intent(this@SuraDetailsActivity, HomeActivity::class.java )
            startActivity(intent)
        }    }

    private fun initSuraTitle() {
        viewBinding.suraName.text = chapterName
    }


    lateinit var chapterName :String
    var chapterIndex :Int =0
    private fun initParams() {
        chapterIndex = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX , 0)
        chapterName  =  intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME)?:""
    }

    private fun loadChapterFile() {
        // will return the all file in string
        val fileContent =   assets.open("$chapterIndex.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")

        bindVerses(lines)
    }

    lateinit var  adapter:ChapterDetailsRecyclerAdapter
    private fun bindVerses(verses: List<String>) {
        adapter = ChapterDetailsRecyclerAdapter(verses)
        viewBinding.suraContentRecyclerView.adapter = adapter
    }



}
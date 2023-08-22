package com.example.islami.Ui.home.tabs.hadeth.hadethContent

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.Ui.Constants
import com.example.islami.databinding.ActivityHadethContentBinding

class HadethContentActivity: AppCompatActivity() {
    lateinit var viewBinding:ActivityHadethContentBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewBinding = ActivityHadethContentBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initParams()
    }


    lateinit var hadethName :String
    var hadethIndex :Int =0

    private fun initParams() {
        hadethIndex = intent.getIntExtra(com.example.islami.Ui.Constants.EXTRA_HADETH_INDEX , 0)
        hadethName = intent.getStringExtra(com.example.islami.Ui.Constants.EXTRA_HADETH_NAME)?:""
        viewBinding.content.hadethTitle.text = hadethName
        viewBinding.content.hadethContent.text = Constants.list_Of_Ahadeth[hadethIndex]
    }


}
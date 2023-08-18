package com.example.islami.Ui.home.tabs.quran

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.Ui.home.HomeActivity
import com.example.islami.databinding.SuraDetailsBinding

class SuraDetailsActivity :AppCompatActivity (){
      lateinit var viewBinding : SuraDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = SuraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.backArrow.setOnClickListener{
            val intent = Intent(this@SuraDetailsActivity, HomeActivity::class.java )
            startActivity(intent)
        }
         var   position:String? =   intent.getStringExtra("chapterPosition")
         var   chapterName:String?=  intent.getStringExtra("chapterName")

    }
}
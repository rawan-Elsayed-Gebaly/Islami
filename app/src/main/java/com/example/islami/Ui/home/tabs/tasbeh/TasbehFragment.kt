package com.example.islami.Ui.home.tabs.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.Ui.home.tabs.quran.ChapterNamesRecyclerAdapter
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.databinding.FragmentTasbehBinding

class TasbehFragment:Fragment() {

    lateinit var viewBinding :FragmentTasbehBinding
    val tasbehListString: List<String> = listOf("سبحان الله", "الحمد لله", "لا إلاه إلا الله" , "الله أكبر")
    private var currentRotation = 0f
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewBinding = FragmentTasbehBinding.inflate(inflater , container , false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var tasbehNum = 1
        var  tasbehTextIndex =0
        viewBinding.tasbehButton.setOnClickListener{
            if(tasbehNum == 34 ){
                currentRotation = 0f
                tasbehNum = 1

                if(tasbehTextIndex == 3){
                    tasbehTextIndex =-1
                }


                tasbehTextIndex+=1

            }
            currentRotation += 10.9f
            val rotateAnimation: Animation = AnimationUtils.loadAnimation(context, R.anim.rotate_animation)
            viewBinding.sebhaImage.startAnimation(rotateAnimation)

            viewBinding.tasbehNumButton.text = "$tasbehNum"
            viewBinding.tasbehButton.text= tasbehListString[tasbehTextIndex]
            tasbehNum+=1

            viewBinding.sebhaImage.rotation = currentRotation


        }


    }


}
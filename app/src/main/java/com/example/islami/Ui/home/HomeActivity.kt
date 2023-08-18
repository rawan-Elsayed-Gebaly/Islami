package com.example.islami.Ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.Ui.home.tabs.hadeth.HadethFragment
import com.example.islami.Ui.home.tabs.quran.QuranFragment
import com.example.islami.Ui.home.tabs.radio.RadioFragment
import com.example.islami.Ui.home.tabs.tasbeh.TasbehFragment
import com.example.islami.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    lateinit var viewBinding :ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quran -> {
                    showFragment(QuranFragment())
                }
                R.id.navigation_radio -> {
                    showFragment(RadioFragment())
                }
                R.id.navigation_tasbeh -> {
                    showFragment(TasbehFragment())
                }
                R.id.navogation_hadeth -> {
                    showFragment(HadethFragment())
                }
            }
            true
        }
        viewBinding.content.bottomNav.selectedItemId = R.id.navigation_quran
    }


    private  fun showFragment(fragment:Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container , fragment )
            .commit()
    }

}
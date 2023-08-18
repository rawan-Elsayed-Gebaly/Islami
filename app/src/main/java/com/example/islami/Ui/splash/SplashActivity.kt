package com.example.islami.Ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islami.R
import com.example.islami.Ui.home.HomeActivity

class SplashActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startHomeActivity()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this@SplashActivity , HomeActivity::class.java)
            startActivity(intent)
        } ,2000)

    }

}
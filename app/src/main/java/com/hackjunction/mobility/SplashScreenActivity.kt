package com.hackjunction.mobility

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_activity)
        supportActionBar?.hide()
        val intent = Intent(this, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
            overridePendingTransition(0,0)
        }, 1500)
    }
}
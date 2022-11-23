package com.example.chap11drawerlayout2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.chap11drawerlayout2.databinding.SplashMainBinding

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SplashMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent( this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
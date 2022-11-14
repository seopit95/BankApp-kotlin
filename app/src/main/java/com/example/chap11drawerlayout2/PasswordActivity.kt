package com.example.chap11drawerlayout2

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chap11drawerlayout2.databinding.ActivityPasswordBinding


class PasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numCount  = object : CountDownTimer(11000,1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = (millisUntilFinished/1000).toString()

            }
            override fun onFinish() {
                Toast.makeText(applicationContext, "시간초과로 비밀번호를 다시 입력해주시기 바랍니다.", Toast.LENGTH_SHORT).show()
                supportFragmentManager
                    .beginTransaction()
                    .replace(androidx.constraintlayout.widget.R.id.constraint, ThreeFragment())
                    .commit()
            }
        }
        numCount.start()



    }
}
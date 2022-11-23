package com.example.chap11drawerlayout2

import android.content.Intent
import android.os.Bundle
import android.view.InflateException
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.chap11drawerlayout2.databinding.FragmentThreeBinding


class ThreeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentThreeBinding.inflate(inflater, container, false)
        val PW = "123456"
        binding.btnPay.setOnClickListener {
            val intent = Intent(context, PasswordActivity::class.java)
            if (binding.edtPW.text.toString().equals(PW)) {
                intent.putExtra("pw", binding.edtPW.text.toString())
                startActivity(intent)
            } else if(binding.edtPW.text.toString().isEmpty()){
                Toast.makeText(context, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if(!binding.edtPW.text.toString().equals(PW)){
                Toast.makeText(context, "비밀번호가 틀렸습니다. 다시 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
        binding.edtPW.text.isEmpty()
    }
}
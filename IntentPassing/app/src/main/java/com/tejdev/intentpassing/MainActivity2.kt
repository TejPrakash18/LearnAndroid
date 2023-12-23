package com.tejdev.intentpassing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tejdev.intentpassing.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private var _binding: ActivityMain2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

         val res = intent.getStringExtra("username")
         binding.tvtext.text = "Hello $res"
    }
}
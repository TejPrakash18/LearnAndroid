package com.tejdev.intentpassing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tejdev.intentpassing.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun gotoActivity(view: View) {
        val username = binding.username.editableText.toString()
        val i = Intent(this, MainActivity2::class.java)
        i.putExtra("username", username)
        startActivity(i)
    }
}
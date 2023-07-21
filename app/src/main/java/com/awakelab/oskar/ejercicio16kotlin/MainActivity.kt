package com.awakelab.oskar.ejercicio16kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.awakelab.oskar.ejercicio16kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    private fun initAdapter() {
        TODO("Not yet implemented")
    }
}
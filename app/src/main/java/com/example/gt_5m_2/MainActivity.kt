package com.example.gt_5m_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gt_5m_2.databinding.ActivityMainBinding
import com.example.gt_5m_2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.akki.hallowenloadersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akki.halloweenloader.HalloweenLoader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val h = findViewById<HalloweenLoader>(R.id.loader)
        h.showProgress()
    }
}
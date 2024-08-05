package com.luthfikarim.bagiwaris

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find ImageButton and set click listener
        val homeButton = findViewById<ImageButton>(R.id.HomeButton) // Pastikan ID sesuai dengan XML
        homeButton.setOnClickListener {
            onHomeButtonClick()
        }
    }

    private fun onHomeButtonClick() {
        val intent = Intent(this, WelcomeKalkulator::class.java)
        startActivity(intent)
    }
}

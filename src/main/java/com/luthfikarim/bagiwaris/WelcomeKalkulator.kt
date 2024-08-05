package com.luthfikarim.bagiwaris

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity

class WelcomeKalkulator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Pastikan ID yang digunakan ada di layout
        val rootView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.root_view)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mulaiHitung = findViewById<ImageButton>(R.id.MulaiHitung)
        mulaiHitung.setOnClickListener {
            onMulaiHitungClick()
        }
    }

    private fun onMulaiHitungClick() {
        // Intent untuk berpindah ke activity lain
        val intent = Intent(/* packageContext = */ this, /* cls = */ KalkulatorDataPewaris::class.java)
        startActivity(intent)
    }
}

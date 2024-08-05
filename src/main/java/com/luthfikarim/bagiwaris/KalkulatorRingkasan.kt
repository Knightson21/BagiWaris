package com.luthfikarim.bagiwaris

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class KalkulatorRingkasan : AppCompatActivity() {

    private lateinit var lanjut5Button: ImageButton
    private lateinit var lanjut6Button: ImageButton
    private lateinit var ulangiButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringkasan)

        // Initialize UI elements
        val imageView14: ImageView = findViewById(R.id.imageView14)
        val textView21: TextView = findViewById(R.id.textView21)
        val textView22: TextView = findViewById(R.id.textView22)
        val textView24: TextView = findViewById(R.id.textView24)
        val textView23: TextView = findViewById(R.id.textView23)
        val textView25: TextView = findViewById(R.id.textView25)
        val textView26: TextView = findViewById(R.id.textView26)
        val textView27: TextView = findViewById(R.id.textView27)
        val textView29: TextView = findViewById(R.id.textView29)
        val textView28: TextView = findViewById(R.id.textView28)
        val textView30: TextView = findViewById(R.id.textView30)
        val textView31: TextView = findViewById(R.id.textView31)
        val textView32: TextView = findViewById(R.id.textView32)

        textView21.text = "Ringkasan"
        textView22.text = "Jenis Kelamin :"
        textView24.text = "Nama :"
        textView23.text = "Pasangan :"
        textView25.text = "Jumlah Anak Laki-Laki :"
        textView26.text = "Jumlah Anak Perempuan :"
        textView27.text = "Ibu Pewaris :"
        textView29.text = "Ayah Pewaris :"
        textView28.text = "Saudari Kandung Pewaris :"
        textView30.text = "Saudara Seayah Pewaris :"
        textView31.text = "Saudara Seibu Pewaris :"
        textView32.text = "Saudara Kandung Pewaris :"

        // Initialize buttons
        lanjut5Button = findViewById(R.id.lanjut5)
        lanjut6Button = findViewById(R.id.lanjut6)
        ulangiButton = findViewById(R.id.ulangiButton)

        lanjut5Button.setOnClickListener { onLanjut5ButtonClick() }
        lanjut6Button.setOnClickListener { onLanjut6ButtonClick() }
        ulangiButton.setOnClickListener { onUlangiButtonClick() }
    }

    private fun onLanjut5ButtonClick() {
        setContentView(R.layout.activity_ringkasan2)
    }

    private fun onUlangiButtonClick() {
        val intent = Intent(this, KalkulatorDataPewaris::class.java)
        startActivity(intent)
    }

    private fun onLanjut6ButtonClick() {
val intent = Intent(this, KalkulatorHasil::class.java)

    }
}

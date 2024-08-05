package com.luthfikarim.bagiwaris

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class KalkulatorDataHarta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_harta) // Ensure this matches your XML layout file name

        // Initialize UI elements
        val rootView: ConstraintLayout = findViewById(R.id.root_view)
        val imageView12: ImageView = findViewById(R.id.imageView12)
        val textView19: TextView = findViewById(R.id.textView19)
        val jumlahHartaEditText: EditText = findViewById(R.id.JumlahHarta)
        val textView20: TextView = findViewById(R.id.textView20)
        val radioGroupHarta: RadioGroup = findViewById(R.id.radioGroupHarta)
        val radioButton12: RadioButton = findViewById(R.id.radioButton12)
        val radioButton13: RadioButton = findViewById(R.id.radioButton13)
        val radioButton14: RadioButton = findViewById(R.id.radioButton14)
        val kembaliButton: ImageButton = findViewById(R.id.kembali4)
        val lanjutButton: ImageButton = findViewById(R.id.lanjut4)
        val imageView13: ImageView = findViewById(R.id.imageView13)

        // Example setup or interactions
        textView19.text = "Data Harta Pewaris"
        jumlahHartaEditText.hint = "Jumlah Harta ...."
        textView20.text = "Jenis Harta"

        radioButton12.text = "Tanah"
        radioButton13.text = "Uang"
        radioButton14.text = "Emas"

        // Set up any necessary listeners or data bindings here
        radioGroupHarta.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButton12 -> {
                    // Handle Tanah selection
                }
                R.id.radioButton13 -> {
                    // Handle Uang selection
                }
                R.id.radioButton14 -> {
                    // Handle Emas selection
                }
            }
        }

        // Set up listeners for ImageButton (if needed)
        val kembali4Button: ImageButton = findViewById(R.id.kembali4)
        kembali4Button.setOnClickListener { onKembali4ButtonClick() }

        val lanjut4Button: ImageButton = findViewById(R.id.lanjut4)
        lanjut4Button.setOnClickListener { onLanjut4ButtonClick() }

    }

    private fun onLanjut4ButtonClick() {
        val intent = Intent(this, KalkulatorRingkasan::class.java)
        startActivity(intent)
    }

    private fun onKembali4ButtonClick() {
        val intent = Intent(this, KalkulatorDataAhliWaris::class.java)
        startActivity(intent)

    }
}

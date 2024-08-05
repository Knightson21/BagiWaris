package com.luthfikarim.bagiwaris

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luthfikarim.bagiwaris.R.layout.activity_data_pewaris

class KalkulatorDataPewaris : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_data_pewaris)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("com.luthfikarim.bagiwaris.PREFERENCES", Context.MODE_PRIVATE)

        // Mengatur padding untuk root view agar sesuai dengan system bars
        val rootView = findViewById<ConstraintLayout>(R.id.root_view)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Mengatur ImageButton untuk kembali
        val kembaliButton = findViewById<ImageButton>(R.id.kembali)
        kembaliButton.setOnClickListener {
            onKembaliButtonClick()
        }

        // Mengatur ImageButton untuk lanjut
        val lanjutButton = findViewById<ImageButton>(R.id.lanjut)
        lanjutButton.setOnClickListener {
            onLanjutButtonClick()
        }

        // Mengatur RadioButton
        val radioButtonLaki = findViewById<RadioButton>(R.id.radioButton2)
        val radioButtonPerempuan = findViewById<RadioButton>(R.id.radioButton3)

        // Menangani pemilihan RadioButton
        radioButtonLaki.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                saveGenderPreference("Laki-laki")
            }
        }

        radioButtonPerempuan.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                saveGenderPreference("Perempuan")
            }
        }

        // Memuat preferensi gender yang tersimpan
        loadGenderPreference()

        // Mengatur EditText
        val editText = findViewById<EditText>(R.id.editTextText2)
        // Validasi atau pengolahan teks bisa ditambahkan di sini

        // Mengatur TextView
        val textViewNama = findViewById<TextView>(R.id.textView6)
        val textViewJenisKelamin = findViewById<TextView>(R.id.text_jkl)
        val textViewStatusPernikahan = findViewById<TextView>(R.id.textView5)
        // Pengaturan teks atau pengolahan lain bisa ditambahkan di sini
    }

    private fun saveGenderPreference(gender: String) {
        val editor = sharedPreferences.edit()
        editor.putString("selected_gender", gender)
        editor.apply()
    }

    private fun loadGenderPreference() {
        val savedGender = sharedPreferences.getString("selected_gender", "")
        when (savedGender) {
            "Laki-laki" -> findViewById<RadioButton>(R.id.radioButton2).isChecked = true
            "Perempuan" -> findViewById<RadioButton>(R.id.radioButton3).isChecked = true
        }
    }

    private fun onKembaliButtonClick() {
        val intent = Intent(this, WelcomeKalkulator::class.java)
        startActivity(intent)
    }

    private fun onLanjutButtonClick() {
        // Validasi EditText jika diperlukan
        val editText = findViewById<EditText>(R.id.editTextText2)
        val name = editText.text.toString().trim()
        if (name.isEmpty()) {
            editText.error = "Nama tidak boleh kosong"
            return
        }

        // Lakukan tindakan lain jika perlu

        // Berpindah ke aktivitas berikutnya
        val intent = Intent(this, KalkulatorDataAhliWaris::class.java)
        startActivity(intent)
    }
}

package com.luthfikarim.bagiwaris

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KalkulatorDataAhliWaris : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_ahli_waris)

        sharedPreferences = getSharedPreferences("com.luthfikarim.bagiwaris.PREFERENCES", Context.MODE_PRIVATE)

        // Mengatur padding untuk root view agar sesuai dengan system bars
        val rootView = findViewById<ConstraintLayout>(R.id.root_view)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Mengatur TextView
        val textViewKondisi: TextView = findViewById(R.id.textView4)

        // Mengatur RadioGroup dan RadioButton
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
        val radioButtonMasihHidup: RadioButton = findViewById(R.id.radioButton5)
        val radioButtonCeraiHidup: RadioButton = findViewById(R.id.radioButton6)
        val radioButtonCeraiMati: RadioButton = findViewById(R.id.radioButton7)

        // Menangani pemilihan RadioButton
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButton5 -> saveRadioButtonPreference("Masih hidup")
                R.id.radioButton6 -> saveRadioButtonPreference("Cerai Hidup")
                R.id.radioButton7 -> saveRadioButtonPreference("Cerai Mati")
            }
        }

        loadRadioButtonPreference()

        // Mengatur EditText dan TextView lainnya
        val textViewJumlahAnak = findViewById<TextView>(R.id.textView10)
        val editTextAnakLaki = findViewById<EditText>(R.id.jmlh_ank_lk)
        val editTextAnakPerempuan = findViewById<EditText>(R.id.jmlh_ank_pr)
        val textViewAnakLaki = findViewById<TextView>(R.id.textView11)
        val textViewAnakPerempuan = findViewById<TextView>(R.id.textView12)

        // Mengatur tombol untuk berpindah aktivitas
        val kembali1Button = findViewById<ImageButton>(R.id.kembali1)
        kembali1Button.setOnClickListener { onKembali1ButtonClick() }

        val lanjut1Button = findViewById<ImageButton>(R.id.lanjut1)
        lanjut1Button.setOnClickListener { onLanjut1ButtonClick() }
    }

    private fun saveRadioButtonPreference(value: String) {
        val editor = sharedPreferences.edit()
        editor.putString("selected_condition", value)
        editor.apply()
    }

    private fun loadRadioButtonPreference() {
        val savedCondition = sharedPreferences.getString("selected_condition", "")
        when (savedCondition) {
            "Masih hidup" -> findViewById<RadioButton>(R.id.radioButton5).isChecked = true
            "Cerai Hidup" -> findViewById<RadioButton>(R.id.radioButton6).isChecked = true
            "Cerai Mati" -> findViewById<RadioButton>(R.id.radioButton7).isChecked = true
        }
    }

    private fun onKembali1ButtonClick() {
        val intent = Intent(this, KalkulatorDataPewaris::class.java)
        startActivity(intent)
    }

    private fun onLanjut1ButtonClick() {
        setContentView(R.layout.activity_data_ahli_waris2)

        // Pindah ke bagian activity_data_ahli_waris2
        // Mengatur TextView
        val textViewOrangTuaPewaris = findViewById<TextView>(R.id.textView7)
        textViewOrangTuaPewaris.text = getString(R.string.orang_tua_pewaris)

        // Mengatur RadioButton
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton9)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton8)
        val radioButton4 = findViewById<RadioButton>(R.id.radioButton10)

        // Menetapkan teks ke RadioButton dari resources strings
        radioButton1.text = getString(R.string.bapak_hidup_ibu_hidup)
        radioButton2.text = getString(R.string.bapak_hidup_ibu_wafat)
        radioButton3.text = getString(R.string.bapak_wafat_ibu_hidup)
        radioButton4.text = getString(R.string.bapak_wafat_ibu_wafat)

        radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButton -> saveRadioButtonPreference("Bapak Hidup, Ibu Hidup")
                R.id.radioButton9 -> saveRadioButtonPreference("Bapak Hidup, Ibu Wafat")
                R.id.radioButton8 -> saveRadioButtonPreference("Bapak Wafat, Ibu Hidup")
                R.id.radioButton10 -> saveRadioButtonPreference("Bapak Wafat, Ibu Wafat")
            }
        }

        val kembali2Button = findViewById<ImageButton>(R.id.kembali2)
        kembali2Button.setOnClickListener { onKembali2ButtonClick() }

        val lanjut2Button = findViewById<ImageButton>(R.id.lanjut2)
        lanjut2Button.setOnClickListener { onLanjut2ButtonClick() }
    }

    private fun onKembali2ButtonClick() {
        setContentView(R.layout.activity_data_ahli_waris)
    }

    private fun onLanjut2ButtonClick() {
        setContentView(R.layout.activity_data_ahli_waris3)

        // Initialize UI elements in activity_data_ahli_waris3
        val imageView10: ImageView = findViewById(R.id.imageView10)
        val sdrkandung3: EditText = findViewById(R.id.sdrkandung3)
        val sdrkandung6: EditText = findViewById(R.id.sdrkandung6)
        val sdrkandung5: EditText = findViewById(R.id.sdrkandung5)
        val textView8: TextView = findViewById(R.id.textView8)
        val sdrkandung: EditText = findViewById(R.id.sdrkandung)
        val sdrkandung4: EditText = findViewById(R.id.sdrkandung4)
        val sdrkandung2: EditText = findViewById(R.id.sdrkandung2)
        val textView9: TextView = findViewById(R.id.textView9)
        val textView17: TextView = findViewById(R.id.textView17)
        val textView14: TextView = findViewById(R.id.textView14)
        val textView13: TextView = findViewById(R.id.textView13)
        val textView16: TextView = findViewById(R.id.textView16)
        val textView15: TextView = findViewById(R.id.textView15)

        val kembali3Button: ImageButton = findViewById(R.id.kembali3)
        kembali3Button.setOnClickListener { onKembali3ButtonClick() }

        val lanjut3Button: ImageButton = findViewById(R.id.lanjut3)
        lanjut3Button.setOnClickListener { onLanjut3ButtonClick() }

        // Set up the image views
        imageView10.setImageResource(R.drawable.bg2)

        //Buttons
        kembali3Button.setImageResource(R.drawable.kiri)
        lanjut3Button.setImageResource(R.drawable.kanan)

        // Set up the edit texts
        sdrkandung3.hint = "isi disini"
        sdrkandung6.hint = "isi disini"
        sdrkandung5.hint = "isi disini"
        sdrkandung.hint = "isi disini"
        sdrkandung4.hint = "isi disini"
        sdrkandung2.hint = "isi disini"

        // Set up the text views
        textView8.text = "Jumlah Saudara"
        textView9.text = "Sdr Seayah Perempuan"
        textView17.text = "Sdr Seayah Perempuan"
        textView14.text = "Sdr Kandung Perempuan"
        textView13.text = "Sdr Seayah Laki-laki"
        textView16.text = "Sdr Seayah Laki-laki"
        textView15.text = "Sdr Kandung Laki-laki"
    }

    private fun onKembali3ButtonClick() {
        setContentView(R.layout.activity_data_ahli_waris2)
    }

    private fun onLanjut3ButtonClick() {
        val intent = Intent(this, KalkulatorDataHarta::class.java)
        startActivity(intent)
    }
}

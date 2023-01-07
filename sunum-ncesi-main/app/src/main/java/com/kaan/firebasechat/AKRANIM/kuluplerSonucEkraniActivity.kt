package com.kaan.firebasechat.AKRANIM

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kaan.firebasechat.R
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_kulupler_sonuc_ekrani.*

class kuluplerSonucEkraniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kulupler_sonuc_ekrani)

        var img: ImageView

        var bct = intent.getIntExtra("bct", 0)

        var hct = intent.getIntExtra("hct", 0)

        var mct = intent.getIntExtra("mct", 0)


        //deneme.text=puanText.text

        when (bct) {
            0 -> BCT.text = "Bu kulup senlik değil"
            1 -> BCT.text = "az öneriliyor"
            2 -> BCT.text = "öneriliyor"
            3 -> BCT.text = "Tam senlik kulüp"
        }

        when (hct) {
            0 -> HCT.text = "Bu kulup senlik değil"
            1 -> HCT.text = "az öneriliyor"
            2 -> HCT.text = "öneriliyor"
            3 -> HCT.text = "Tam senlik kulüp"
        }

        when (mct) {
            0 -> MCT.text = "Bu kulup senlik değil"
            1 -> MCT.text = "az öneriliyor"
            2 -> MCT.text = "öneriliyor"
            3 -> MCT.text = "Tam senlik kulüp"
        }

        don.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
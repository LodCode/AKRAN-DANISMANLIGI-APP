package com.kaan.firebasechat.AKRANIM

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.activity_kulup_testi.*

class kulupTesti : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var sorular= arrayOf("Bilisim alanindaki kariyer olanaklarini ogrenmek ve bilgi sahibi olmak ilgini cekiyor mu? ","Muzik ve Sahne ile ilgileniyor ve onunla ilgi bir seyler yapmak ister misin ? ","Psikoloji alanida uzman konuklari agirlamak ve soylesilerine katilmak ilgini cekiyor mu ?_","Yazilim alaninda projeler gelistirip cesitli yarismalara katilmak ister misin ?",
            "Herhangi bir enstruman aleti caliyor musun ? ","Farkli konulari tartisip bu konular uzerine konusmak ister misin ?","Bilisim sektorunun oncu firmalarinin ofisleri ve calisma alanlarini ziyaret edip  \n" +
                    "\n" +
                    "Isi mutfaginda gormek ister misin ?","Sahne almak ve bir grupla birlikte muzik yapmak ilgini cekiyor mu ? ","Cesitli terapi etkinliklerine katilip psikoloji alaninda bilgiler kazanmak ilgini ceker mi ?"
            ,"TEST BİTTİ")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kulup_testi)

        var bct=0
        var hct=0
        var mct=0

        var soru=0;

        puanlar.text="bct: ${bct} hct: ${hct} mct: ${mct}"



        //   soruText.text="${soru}"


        soruText.text = sorular[soru]


        evetButton.setOnClickListener {
            if(soru<sorular.size-1) {
                when(soru){
                    0 -> bct=bct+1
                    3 -> bct=bct+1
                    6 -> bct=bct+1
                    1 -> mct=mct+1
                    4 -> mct=mct+1
                    7 -> mct=mct+1
                    2 -> hct=hct+1
                    5 -> hct=hct+1
                    8 -> hct=hct+1
                }
                puanlar.text="bct: ${bct} hct: ${hct} mct: ${mct}"
                soru++
                soruText.text = sorular[soru]

            }
            else {
                Toast.makeText(applicationContext, "test bitti", Toast.LENGTH_SHORT).show()
            }
        }

        hayırButton.setOnClickListener {
            if(soru<sorular.size-1) {
                puanlar.text="bct: ${bct} hct: ${hct} mct: ${mct}"
                soru++
                soruText.text = sorular[soru]
            }
            else {
                Toast.makeText(applicationContext, "test bitti", Toast.LENGTH_SHORT).show()
            }
        }

        val testibitir = findViewById<Button>(R.id.testiBitir)

        testibitir.setOnClickListener {
            val intent = Intent(this, kuluplerSonucEkraniActivity::class.java)

            intent.putExtra("bct", bct); //veri gönderiliyor
            intent.putExtra("hct", hct); //veri gönderiliyor
            intent.putExtra("mct", mct); //veri gönderiliyor
            startActivity(intent)

        }
    }

}

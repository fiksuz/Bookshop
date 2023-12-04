package com.mobilapp.proba_prj.konyvek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mobilapp.proba_prj.R
import com.mobilapp.proba_prj.payment.Payment

class VODActivity: AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.konyv)

            val megvetel_gomb = findViewById<Button>(R.id.button_megvetel)
            megvetel_gomb.setOnClickListener {
                val intent = Intent(this, Payment::class.java)
                startActivity(intent)
            }
        }
}
package com.mobilapp.proba_prj.konyvek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mobilapp.proba_prj.R
import com.mobilapp.proba_prj.payment.Payment

class RWRActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.harmadik_konyv)

        val megvetel_gombharom = findViewById<Button>(R.id.buttonharom)
        megvetel_gombharom.setOnClickListener {
            val intent = Intent(this, Payment::class.java)
            startActivity(intent)
    }
}
}
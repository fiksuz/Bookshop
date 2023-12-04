package com.mobilapp.proba_prj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast
import com.mobilapp.proba_prj.konyvek.LYDActivity
import com.mobilapp.proba_prj.konyvek.RWRActivity
import com.mobilapp.proba_prj.konyvek.VODActivity
import com.mobilapp.proba_prj.listaosztalyok.Tobb
import com.mobilapp.proba_prj.listaosztalyok.Tobb_kat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kep = findViewById<ImageView>(R.id.kerekitett_kep)
        kep.setOnClickListener {
            val intent = Intent(this, VODActivity::class.java)
            startActivity(intent)
        }

        val kep_ketto = findViewById<ImageView>(R.id.kerekitett_kep3)
        kep_ketto.setOnClickListener {
            val intent = Intent(this, LYDActivity::class.java)
            startActivity(intent)
        }
        val kep_harom = findViewById<ImageView>(R.id.kerekitett_kep2)
        kep_harom.setOnClickListener {
            val intent = Intent(this, RWRActivity::class.java)
            startActivity(intent)
        }
        val gomb1 = findViewById<Button>(R.id.kovetkezogomb)
        gomb1.setOnClickListener {
            val intent = Intent(this, Tobb::class.java)
            startActivity(intent)
        }
        val gomb2 = findViewById<Button>(R.id.kovetkezogomb_masodik)
        gomb2.setOnClickListener {
            val intent = Intent(this, Tobb_kat::class.java)
            startActivity(intent)
        }


        val ratingBar = findViewById<RatingBar>(R.id.rating_elso)
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(this, "Értékelés: $rating", Toast.LENGTH_SHORT).show()
        }

        val ratingBar_masodik = findViewById<RatingBar>(R.id.rating_masoik)
        ratingBar_masodik.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(this, "Értékelés: $rating", Toast.LENGTH_SHORT).show()
        }

        val ratingBar_harmadik = findViewById<RatingBar>(R.id.rating_harmadik)
        ratingBar_harmadik.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(this, "Értékelés: $rating", Toast.LENGTH_SHORT).show()
        }

    }
}
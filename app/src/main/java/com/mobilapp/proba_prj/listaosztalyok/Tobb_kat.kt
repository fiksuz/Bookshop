package com.mobilapp.proba_prj.listaosztalyok


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mobilapp.proba_prj.MainActivity
import com.mobilapp.proba_prj.R

class Tobb_kat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tobb_kategoriak)

        val visszagomb = findViewById<Button>(R.id.visszagomb)
        visszagomb.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}

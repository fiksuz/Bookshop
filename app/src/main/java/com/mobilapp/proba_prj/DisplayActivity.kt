package com.mobilapp.proba_prj

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mobilapp.proba_prj.R

class DisplayActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adatok)

        val cardNumber = intent.getStringExtra("CARD_NUMBER")
        val name = intent.getStringExtra("NAME")
        val email = intent.getStringExtra("EMAIL")
        val cvc = intent.getStringExtra("CVC")
        val date = intent.getStringExtra("DATE")


        val textCardNumber = findViewById<TextView>(R.id.textCardNumber)
        val textName = findViewById<TextView>(R.id.textName)
        val textEmail = findViewById<TextView>(R.id.textEmail)
        val textCVC = findViewById<TextView>(R.id.textCVC)
        val textDate = findViewById<TextView>(R.id.textDate)


        textCardNumber.text = " $cardNumber"
        textName.text = " $name"
        textEmail.text = " $email"
        textCVC.text = " $cvc"
        textDate.text = " $date"

        dbHelper = DatabaseHelper(this)
        insertData(cardNumber, name, email, cvc, date)
    }

    private fun insertData(cardNumber: String?, name: String?, email: String?, cvc: String?, date: String?) {
        val db = dbHelper.writableDatabase

        db.beginTransaction()
        try {
            val values = ContentValues().apply {
                put(DatabaseHelper.COLUMN_CARD_NUMBER, cardNumber)
                put(DatabaseHelper.COLUMN_NAME, name)
                put(DatabaseHelper.COLUMN_EMAIL, email)
                put(DatabaseHelper.COLUMN_CVC, cvc)
                put(DatabaseHelper.COLUMN_DATE, date)
            }

            val newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values)


            if (newRowId != -1L) {
                Log.d("DisplayActivity", "Data inserted successfully. Row ID: $newRowId")
                db.setTransactionSuccessful()  // Commit
            } else {
                Log.e("DisplayActivity", "Failed to insert data.")
            }
        } finally {
            db.endTransaction()
        }
    }
}

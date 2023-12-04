package com.mobilapp.proba_prj.payment

import com.mobilapp.proba_prj.DisplayActivity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.mobilapp.proba_prj.R


class Payment: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment)

        val expiryDateEditText = findViewById<TextInputEditText>(R.id.date_text)

        expiryDateEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.length == 2 && !s.toString().contains("/")) {
                    // Ha két karakter után nincs perjel, akkor hozzáadunk egy perjelet
                    s.append("/")
                }
            }
        })

        val saveButton: Button = findViewById(R.id.button3)

        saveButton.setOnClickListener {
            // Adatok lekérése az EditText-ekből
            val cardNumber = findViewById<EditText>(R.id.edit_text).text.toString()
            val name = findViewById<EditText>(R.id.name_text).text.toString()
            val email = findViewById<EditText>(R.id.email_text).text.toString()
            val cvc = findViewById<EditText>(R.id.cvc_text).text.toString()
            val date = findViewById<EditText>(R.id.date_text).text.toString()

            // Intent létrehozása az adatok átadásához
            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra("CARD_NUMBER", cardNumber)
                putExtra("NAME", name)
                putExtra("EMAIL", email)
                putExtra("CVC", cvc)
                putExtra("DATE", date)
            }

            // Új Activity elindítása az Intenttel
            startActivity(intent)
        }
    }
}





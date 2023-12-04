package com.mobilapp.proba_prj

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "app_database"
        const val DATABASE_VERSION = 2
        const val TABLE_NAME = "user_table"
        const val COLUMN_ID = "id"
        const val COLUMN_CARD_NUMBER = "cardNumber"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_CVC = "cvc"
        const val COLUMN_DATE = "date"
    }

    private val SQL_CREATE_ENTRIES = """
        CREATE TABLE $TABLE_NAME (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_CARD_NUMBER TEXT,
            $COLUMN_NAME TEXT,
            $COLUMN_EMAIL TEXT,
            $COLUMN_CVC TEXT,
            $COLUMN_DATE TEXT
        )
    """.trimIndent()

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)


        fun getAllUsers(): List<Felhaszn> {
            val userList = mutableListOf<Felhaszn>()
            val db = readableDatabase

            val projection = arrayOf(
                COLUMN_ID,
                COLUMN_CARD_NUMBER,
                COLUMN_NAME,
                COLUMN_EMAIL,
                COLUMN_CVC,
                COLUMN_DATE
            )

            val cursor = db?.query(
                TABLE_NAME,  // Tábla neve
                projection,  // Visszaadott oszlopok
                null,  // WHERE clause
                null,  // WHERE arguments
                null,  // GROUP BY
                null,  // HAVING
                null   // ORDER BY
            )

            cursor?.use {
                while (it.moveToNext()) {
                    val user = Felhaszn(
                        it.getLong(it.getColumnIndexOrThrow(COLUMN_ID)),
                        it.getString(it.getColumnIndexOrThrow(COLUMN_CARD_NUMBER)),
                        it.getString(it.getColumnIndexOrThrow(COLUMN_NAME)),
                        it.getString(it.getColumnIndexOrThrow(COLUMN_EMAIL)),
                        it.getString(it.getColumnIndexOrThrow(COLUMN_CVC)),
                        it.getString(it.getColumnIndexOrThrow(COLUMN_DATE))
                    )
                    userList.add(user)
                }
            }

            return userList
        }

    }
}

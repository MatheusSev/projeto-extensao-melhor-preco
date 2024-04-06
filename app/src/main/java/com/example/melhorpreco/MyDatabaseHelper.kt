package com.example.melhorpreco

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ListaDB.db"
        private const val TABLE_NAME = "Lista"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOME = "nome"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NOME TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun teste(db: SQLiteDatabase?) {
        // Exemplos de dados de teste
        val exemplos = listOf("Exemplo 1", "Exemplo 2", "Exemplo 3")

        // Inserir exemplos na tabela
        val contentValues = ContentValues()
        for (exemplo in exemplos) {
            contentValues.clear()
            contentValues.put(COLUMN_NOME, exemplo)
            db?.insert(TABLE_NAME, null, contentValues)
        }
    }

}

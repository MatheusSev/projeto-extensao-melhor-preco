package com.example.melhorpreco

import android.app.Activity
import android.os.Bundle
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.widget.ArrayAdapter
//import android.widget.ListView
import android.widget.TextView

class ShowLists : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showlists)

        // Abrir o banco de dados
        val dbHelper = MyDatabaseHelper(this)
        val db: SQLiteDatabase = dbHelper.readableDatabase

        // Consulta para obter os nomes das listas
        val cursor: Cursor = db.rawQuery("SELECT nome FROM Lista", null)

        // Extrair os nomes das listas do cursor
        val listaNomes = ArrayList<String>()
        while (cursor.moveToNext()) {
            val columnIndex = cursor.getColumnIndex("nome")
            if (columnIndex >= 0) {
                // A coluna "nome" existe no cursor
                val nome = cursor.getString(columnIndex)
                listaNomes.add(nome)
            } else {
                // A coluna "nome" não foi encontrada no cursor
                // Lide com isso adequadamente
            }

        }
        cursor.close()
        db.close()

        // Exibir os nomes das listas em um ListView
        val TextView: TextView = findViewById(R.id.list_item_text)
        val adapter = ArrayAdapter<String>(this, R.layout.list_item, R.id.list_item_text, listaNomes)
        TextView.text = adapter.toString()

    }
}

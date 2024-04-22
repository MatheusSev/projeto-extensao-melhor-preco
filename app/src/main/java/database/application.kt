package database

import ShoppingListDatabase
import android.app.Application
import androidx.room.Room

class MyApp : Application() {
    lateinit var database: ShoppingListDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            ShoppingListDatabase::class.java, "shopping_list_database"
        ).build()
    }
}

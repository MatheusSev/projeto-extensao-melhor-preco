package database
import ShoppingList
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM shopping_lists")
    fun getAllLists(): List<ShoppingList>

    @Insert
    fun insertList(list: ShoppingList)

    // Adicione outras operações de CRUD conforme necessário
}

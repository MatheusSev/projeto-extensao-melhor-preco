import java.sql.Connection
import java.sql.DriverManager
data class usuario(
    val codUsu: Int,
    val nome: String,
    val email: String,
    val senha: String
)
data class lista(
    val codLista: Int,
    val codMercado: Int,
    val nomeMercado: String,
    val nomeProd: String,
    val quant: Int,
    val preco: Float
)
data class produto(
    val codProd: Int,
    val nomeProd: String,
    val vol: Int,
    val peso: Int,
    val gtin: Int,
    val marca: String
)
data class mercado(
    val codMercado: Int,
    val nomeMercado: String,
    val razaoSocial: String,
    val cnpj: Int,
    val endereco: String
)
data class preco(
    val preco: Float,
    val dataPreco: String,
    val codProd: Int
)
interface UsuarioDAO {
    fun inserirUsuario(user: user)
    fun deletarUsuario(user: user)

    fun atualizarUsuario
}
interface ListaDAO {
    fun criarLista(lista: Lista)

    fun excluirLista

    fun consultarLista
}
interface ProdutoDAO {
    fun inserirProduto(produto: Produto)
    fun buscarProduto(nomeProd: String): Produto?

    fun excluirProduto
}

interface MercadoDAO {
    fun inserirMercado(mercado: Mercado)

    fun buscarMercado(nomeMercado: String): Mercado?

    fun atualizarMercado

}

interface PrecoDAO {
    fun inserirPreco(preco: Preco)
    fun atualizarPreco(codProd: Int): Preco?
}

// Implementação básica das interfaces DAO utilizando SQLite como exemplo
class SQLiteUsuarioDAO(private val connection: Connection) : UsuarioDAO {
    override fun inserirUsuario(user: user) {
        // Implementação para inserir um usuário no banco de dados SQLite
    }

    override fun buscarUsuarioPorEmail(email: String): user? {
        // Implementação para buscar um usuário por e-mail no banco de dados SQLite
        return null
    }
}

// Implementação básica das interfaces DAO utilizando SQLite como exemplo
class SQLiteListaDAO(private val connection: Connection) : ListaDAO {
    override fun inserirLista(lista: Lista) {
        // Implementação para inserir uma lista no banco de dados SQLite
    }

    override fun buscarListaPorNomeProduto(nomeProd: String): Lista? {
        // Implementação para buscar uma lista por nome de produto no banco de dados SQLite
        return null
    }
}

// Implementação básica das interfaces DAO utilizando SQLite como exemplo
class SQLiteProdutoDAO(private val connection: Connection) : ProdutoDAO {
    override fun inserirProduto(produto: Produto) {
        // Implementação para inserir um produto no banco de dados SQLite
    }

    override fun buscarProdutoPorNome(nomeProd: String): Produto? {
        // Implementação para buscar um produto por nome no banco de dados SQLite
        return null
    }
}

// Implementação básica das interfaces DAO utilizando SQLite como exemplo
class SQLiteMercadoDAO(private val connection: Connection) : MercadoDAO {
    override fun inserirMercado(mercado: Mercado) {
        // Implementação para inserir um mercado no banco de dados SQLite
    }

    override fun buscarMercadoPorNome(nomeMercado: String): Mercado? {
        // Implementação para buscar um mercado por nome no banco de dados SQLite
        return null
    }
}

// Implementação básica das interfaces DAO utilizando SQLite como exemplo
class SQLitePrecoDAO(private val connection: Connection) : PrecoDAO {
    override fun inserirPreco(preco: Preco) {
        // Implementação para inserir um preço no banco de dados SQLite
    }

    override fun buscarPrecoPorCodigoProduto(codProd: Int): Preco? {
        // Implementação para buscar um preço por código de produto no banco de dados SQLite
        return null
    }
}

// Função para criar a conexão com o banco de dados SQLite
fun connector(): Connection {
    val url = "jdbc:sqlite:shopping_list.db"
    return DriverManager.getConnection(url)
}

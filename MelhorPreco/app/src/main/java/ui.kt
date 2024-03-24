    import javafx.application.Application
    import javafx.geometry.Insets
    import javafx.scene.Scene
    import javafx.scene.control.Button
    import javafx.scene.control.TextField
    import javafx.scene.layout.VBox
    import javafx.stage.Stage

    class ui : Application() {
        private lateinit var textField: TextField

        override fun start(primaryStage: Stage) {
            textField = TextField()
            textField.promptText = "Digite o nome da lista de compras"

            val confirmarButton = Button("Confirmar")
            confirmarButton.setOnAction { criarLista() }

            val cancelarButton = Button("Cancelar")
            cancelarButton.setOnAction { limparCampo() }

            val layout = VBox(10.0)
            layout.padding = Insets(20.0)
            layout.children.addAll(textField, confirmarButton, cancelarButton)

            val scene = Scene(layout, 300.0, 200.0)

            primaryStage.title = "Minha Interface Gráfica"
            primaryStage.scene = scene
            primaryStage.show()
        }

        private fun criarLista() {
            val nomeLista = textField.text
            println("Lista criada com o nome: $nomeLista")
        }

        private fun limparCampo() {
            textField.clear()
        }

        companion object {
            @JvmStatic
            fun main(args: Array<String>) {
                launch(MinhaInterfaceGrafica::class.java)
            }
        }
    }

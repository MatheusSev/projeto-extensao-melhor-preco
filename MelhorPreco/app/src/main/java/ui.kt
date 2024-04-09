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
            textField.promptText = "Digite do item que deseja"

            val confirmarButton = Button("Confirmar")
            confirmarButton.setOnAction { criarLista() }

            val cancelarButton = Button("Cancelar")
            cancelarButton.setOnAction { limparCampo() }

            val layout = VBox(10.0)
            layout.padding = Insets(20.0)
            layout.children.addAll(textField, confirmarButton, cancelarButton)

            val scene = Scene(layout, 480.0, 360.0)

            primaryStage.title = "Interface Gráfica"
            primaryStage.scene = scene
            primaryStage.show()
        }

        private fun criarLista() {
            val nomeLista = textField.text
            println("Lista com o nome: $nomeLista")
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

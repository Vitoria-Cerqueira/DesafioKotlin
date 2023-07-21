import kotlin.system.exitProcess

class SistemaDeRegistro {
    val carrinho = Compra()
    fun menuPrincipal() {
        var opcao = 0
        do {
            try {
                println("--------- Bem-Vindo -----------")
                println("Escolha uma opção\n1- Lanches\n2- Bebidas\n3- Sobremesa")
                opcao = readln().toInt()
                when (opcao) {
                    1->{menuLanche()}
                    2->{menuBebida()}
                    3->{menuSobremesa()}
                    else -> println("Opção invalida, tente nvamente")
                }
            } catch (exception: NumberFormatException) {
                exception.printStackTrace()
                println("Formato inválido, para escolher o item, você deve informar o número dele")
            }
        } while (opcao != 1 && opcao != 2 && opcao != 3)
    }
    private fun menuLanche() {
        var opcao = 0
        do {
            try {
                println("Escolha uma opção\n1- X-Burguer\n2- X-Salada")
                opcao = readln().toInt()
                when (opcao) {
                    1 -> {adicionarItemCarrinho(XBurguer())}
                    2 -> {adicionarItemCarrinho(XSalada())}
                    else -> println("Opção invalida, tente nvamente")
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                println("Formato inválido, para escolher o item, você deve informar o número dele")
            }
        } while (opcao != 1 && opcao != 2)
    }
    private fun menuBebida() {
        var opcao = 0
        do {
            try {
                println("Escolha uma opção\n1- Refrigerante\n2- Suco")
                opcao = readln().toInt()
                when (opcao) {
                    1 -> {adicionarItemCarrinho(Refrigerante())}
                    2 -> {adicionarItemCarrinho(Suco())}
                    else -> println("Opção invalida, tente nvamente")
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                println("Formato inválido, para escolher o item, você deve informar o número dele")
            }
        } while (opcao != 1 && opcao != 2)
    }
    private fun menuSobremesa() {
        var opcao = 0
        do {
            try {
                println("Escolha uma opção\n1- Bolo chocolate\n2- Cookies\n3- Sorvete")
                opcao = readln().toInt()
                when (opcao) {
                    1 -> {adicionarItemCarrinho(BoloDeChocolate())}
                    2 -> {adicionarItemCarrinho(Cookies())}
                    3 -> {adicionarItemCarrinho(Sorvete())}
                    else -> println("Opção invalida, tente nvamente")
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                println("Formato inválido, para escolher o item, você deve informar o número dele")
            }
        } while (opcao != 1 && opcao != 2 && opcao != 3)


    }
    private fun adicionarItemCarrinho(produto: Produto) {
        println("Digite a quantidade desejada: ")
        val quantidade = readln().toIntOrNull()

        if (quantidade != null && quantidade > 0) {
            carrinho.acrescentarProduto(produto, quantidade)
            carrinho.exibirCarrinho()
        }
        var opcao = 0
        do {
            try {
                println("Escolha uma opção\n1- Comprar mais itens\n2- Editar item\n3- Remover item\n4- Finalizar pedido")
                opcao = readln().toInt()
                println()
                when (opcao) {
                    1 -> {menuPrincipal()}
                    2 -> {editarItem()}
                    3 -> {removerItem()}
                    4 -> {finalizarPedido()}
                    else -> println("Opção invalida, tente nvamente")
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                println("Formato inválido, para escolher o item, você deve informar o número dele")

            }
        } while (opcao != 4)
    }
    private fun editarItem() {
        println("Digite o codigo do produto que você deseja editar: ")
        val codigo = readln().toIntOrNull()
        if (codigo != null) {

            println("Digite a nova quantidade: ")
            val novaQuantidade = readln().toIntOrNull()

            if (novaQuantidade != null && novaQuantidade > 0) {
                carrinho.editarQuantidade(codigo, novaQuantidade)
                carrinho.exibirCarrinho()
            } else {
                println("Quantidade inválida, tente novamente")
            }
        } else {
            println("Opção inválida")
        }
    }
    private fun removerItem() {
        println("Digite o codigo do produto que deseja remover: ")
        val codigo = readln().toIntOrNull()
        if (codigo != null) {
            carrinho.remover(codigo)
            carrinho.exibirCarrinho()
        }
    }
    private fun finalizarPedido() {
        carrinho.exibirCarrinho()
        var opcao = 0
        while (true) {
            try {
                println("Qual a forma de pagamento:\n1- Cartão de crédito\n2- Cartão de débito\n3- Vale refeição\n4- Dinheiro\n")
                opcao = readln().toInt()
                when (opcao) {
                    1 -> {
                        println("Compra finalizada com sucesso! Boa refeição")
                        exitProcess(0)
                    }
                    2 -> {
                        println("Compra finalizada com sucesso! Boa refeição")
                        exitProcess(0)
                    }
                    3 -> {
                        println("Compra finalizada com sucesso! Boa refeição")
                        exitProcess(0)
                    }
                    4 -> {
                        println("Qual valor você usará pra pagar?")
                        val valorDinheiro = readln().toDouble()
                        val troco = valorDinheiro - carrinho.calcularTotal()
                        if (troco >= 0) {
                            println("Seu troco é: R$$troco. Compra finalizada com sucesso! Boa refeição")
                            exitProcess(0)
                        } else {
                            println("Valor insuficiente")
                        }
                    }
                    else -> println("Opção invalida, tente nvamente")
                }
            } catch (ex: NumberFormatException) {
                ex.printStackTrace()
                println("Formato inválido, para escolher o item, você deve informar o número dele")
            }

        }
    }
}
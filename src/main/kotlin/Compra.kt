class Compra {
    val produtos = mutableMapOf<Produto,Int>()

    fun acrescentarProduto(produto: Produto, quantidade: Int){
        produtos.keys.find { it == produto}
        produtos[produto] = quantidade
    }
    fun editarQuantidade(codigo: Int, novaQuantidade: Int){
        val produto = produtos.keys.find { it.codigo == codigo }
        if (produto != null) produtos[produto] = novaQuantidade
    }
    fun remover(codigo: Int){
        val produto = produtos.keys.find { it.codigo == codigo }
        if (produto != null) produtos.remove(produto)

    }
    fun calcularTotal(): Double{
        var total = 0.0
        for ((produto,quantidade)in produtos){
            total += produto.valorUnitario * quantidade
        }
        return total
    }
    fun exibirCarrinho(){
        if (produtos.isNotEmpty()){
            println("-------- Carrinho de compras ----------")
            for ((produto, quantidade )in produtos){
                val totalItem = produto.valorUnitario * quantidade
                println("${produto.nome}\nCodigo: ${produto.codigo}\nQuantidade: $quantidade\nValor Unitario: R$${produto.valorUnitario}\nTotal: R$$totalItem")
                println()
            }
            println("Total da compra: R$${calcularTotal()}")
            println("--------------------------------------------")
        }else{
            println("Carrinho vazio")
        }
    }
}
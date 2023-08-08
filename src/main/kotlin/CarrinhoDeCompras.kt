class CarrinhoDeCompras {
    val itens = mutableMapOf<Produto,Int>()
    fun acrescentarItem(produto: Produto, quantidade: Int){
        itens.keys.find { it == produto}
        itens[produto] = quantidade
    }
    fun editarQuantidadeDoItem(codigo: Int, novaQuantidade: Int){
        val produto = encontrarProdutoPorCodigo(codigo)
        if (produto != null) itens[produto] = novaQuantidade
    }
    fun removerItem(codigo: Int){
        val produto = encontrarProdutoPorCodigo(codigo)
        if (produto != null) itens.remove(produto)
    }
    fun calcularTotal(): Double{
        var total = 0.0
        for ((produto,quantidade)in itens){
            total += produto.valorUnitario * quantidade
        }
        return total
    }
    fun exibirCarrinho(){
        if (itens.isNotEmpty()){
            println("-------- Carrinho de compras ----------")
            for ((produto, quantidade )in itens){
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
    private fun encontrarProdutoPorCodigo(codigo: Int): Produto?{
        return itens.keys.find { it.codigo == codigo }
    }
}
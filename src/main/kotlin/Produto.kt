open class Produto( var nome: String,var valorUnitario : Double ){
     var codigo: Int = 1
}
class XBurguer(): Produto("X-Burguer",10.00){
    companion object{
        private var codigoAtual = 100
    }
    init {
        this.codigo = codigoAtual++
    }
}
class XSalada(): Produto("X-Salada", 12.00){
    companion object{
        private var codigoAtual = 200
    }
    init {
        this.codigo = codigoAtual++
    }
}
class Refrigerante(): Produto("Refrigerante",8.00){
    companion object{
        private var codigoAtual = 300
    }
    init {
        this.codigo = codigoAtual++
    }
}
class Suco(): Produto("Suco",6.00){
    companion object{
        private var codigoAtual = 400
    }
    init {
        this.codigo = codigoAtual++
    }
}
class BoloDeChocolate(): Produto("Bolo de chocolate", 13.00){
    companion object{
        private var codigoAtual = 50
    }
    init {
        this.codigo = codigoAtual++
    }
}
class Cookies(): Produto("Cookies", 14.00){
    companion object{
        private var codigoAtual = 30
    }
    init {
        this.codigo = codigoAtual++
    }
}
class Sorvete(): Produto("Sorvete", 9.00){
    companion object{
        private var codigoAtual = 20
    }
    init {
        this.codigo = codigoAtual++
    }
}



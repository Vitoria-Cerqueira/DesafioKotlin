open class Produto(var codigo: Int,var nome: String,var valorUnitario : Double ){}
object codigoGerado{
    var codigoAtual = 100
    fun novoCodigo(): Int{
        return codigoAtual++
    }
}
class XBurguer(): Produto(codigoGerado.novoCodigo(),"X-Burguer", 10.00){}
class XSalada(): Produto(codigoGerado.novoCodigo(),"X-Salada", 12.00){}
class Refrigerante(): Produto(codigoGerado.novoCodigo(),"Refrigerante", 8.00){}
class Suco(): Produto(codigoGerado.novoCodigo(),"Suco", 6.00){}
class BoloDeChocolate(): Produto(codigoGerado.novoCodigo(),"Bolo de chocolate", 13.00){}
class Cookies(): Produto(codigoGerado.novoCodigo(),"Cookies", 14.00){}
class Sorvete(): Produto(codigoGerado.novoCodigo(),"Sorvete", 9.00){}



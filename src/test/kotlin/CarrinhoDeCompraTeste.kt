import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test



class CarrinhoDeCompraTeste {
        private lateinit var compra: CarrinhoDeCompras
        private lateinit var produto1: Produto
        private lateinit var produto2: Produto

        @BeforeEach
        fun configurar() {

            compra = CarrinhoDeCompras()
            produto1 = Produto(codigoGerado.codigoAtual,"X-Burguer",10.0)
            produto2 = Produto(codigoGerado.codigoAtual,"X-Salada", 12.0)
        }

        @Test
        fun testeAcrescentarProduto() {
            compra.acrescentarItem(produto1, 2)
            compra.acrescentarItem(produto2, 3)

            assertEquals(2, compra.itens[produto1])
            assertEquals(3, compra.itens[produto2])
        }

        @Test
        fun testeEditarQuantidade() {
            compra.acrescentarItem(produto1, 2)
            compra.editarQuantidadeDoItem(1, 5)

            assertEquals(2, compra.itens[produto1])
        }

        @Test
        fun testeRemover() {
            compra.acrescentarItem(produto1, 2)
            compra.removerItem(1)

            assertFalse(compra.itens.isEmpty())
        }

        @Test
        fun testeCalcularTotal() {
            compra.acrescentarItem(produto1, 2)
            compra.acrescentarItem(produto2, 3)

            val totalEsperado = (2 * produto1.valorUnitario) + (3 * produto2.valorUnitario)
            assertEquals(totalEsperado, compra.calcularTotal())
        }


    }


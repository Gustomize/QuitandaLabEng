package br.com.fatec.quitanda.quitanda.repository;

import br.com.fatec.quitanda.quitanda.model.Carrinho;
import br.com.fatec.quitanda.quitanda.model.ProdutoPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, ProdutoPedidoId> {

    @Query(value = "SELECT c.idProduto, c.quantidade FROM Carrinho c WHERE c.idPedido=:idPedido", nativeQuery = false)
    List<Carrinho> listarItensPedido(@Param("idPedido") Long idPedido);

    @Query(value = "DELETE FROM Carrinho c where c.idPedido = :idPedido, c.idProduto = idProduto", nativeQuery = false)
    void removerDoCarrinho(@Param("idPedido") Long idPedido, @Param("idProduto") Long idProduto);

    @Query(value = "UPDATE Carrinho c set c.quantidade=:quantidade WHERE idPedido=:idPedido, idProduto=:idProduto", nativeQuery = false)
    void alterarQuantidade(@Param("quantidade") int quantidade, @Param("idPedido") Long idPedido, @Param("idProduto") Long idProduto);

}

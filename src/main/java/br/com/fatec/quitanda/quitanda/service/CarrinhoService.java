package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Carrinho;
import br.com.fatec.quitanda.quitanda.model.Pedido;
import br.com.fatec.quitanda.quitanda.model.Produto;
import br.com.fatec.quitanda.quitanda.model.ProdutoPedidoId;
import br.com.fatec.quitanda.quitanda.repository.CarrinhoRepository;
import br.com.fatec.quitanda.quitanda.repository.PedidoRepository;
import br.com.fatec.quitanda.quitanda.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;


    public List<Carrinho> listarItensPedido(Long idPedido) {
        return carrinhoRepository.listarItensPedido(idPedido);
    }

    public Carrinho adicionarAoCarrinho(Long idPedido, Long idProduto, int quantidade) {
        Pedido pedido = pedidoRepository.findById(idPedido).get();
        Produto produto = produtoRepository.findById(idProduto).get();

        ProdutoPedidoId id = new ProdutoPedidoId();
        id.setIdPedido(idPedido);
        id.setIdProduto(idProduto);

        Carrinho item = new Carrinho();
        item.setId(id);
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(quantidade);

        return carrinhoRepository.save(item);
    }

    public void removerDoCarrinho(Long idPedido, Long idProduto) {
        carrinhoRepository.removerDoCarrinho(idPedido, idProduto);
    }

    public void alterarQuantidade(int quantidade, Long idPedido, Long idProduto) {
        carrinhoRepository.alterarQuantidade(quantidade, idPedido, idProduto);
    }

}

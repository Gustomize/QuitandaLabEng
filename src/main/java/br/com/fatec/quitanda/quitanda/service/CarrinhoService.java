package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Carrinho;
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

    public List<Carrinho> carrinhos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho listarCarrinho(ProdutoPedidoId id) {
        return carrinhoRepository.findById(id).orElseThrow(()-> new RuntimeException("Carrinho não encontrado!!"));
    }

    public Carrinho cadastrarCarrinho(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public void deletarCarrinho(ProdutoPedidoId id) {
        carrinhoRepository.deleteById(id);
    }

    public Produto alterarProduto(ProdutoPedidoId id, Produto produto) {
        Optional<Carrinho> c = carrinhoRepository.findById(id);
        if (c.isPresent()) {
            c.get().set(produto.getNomeProduto());
        }
        return carrinhoRepository.save(c.get());
    }
}

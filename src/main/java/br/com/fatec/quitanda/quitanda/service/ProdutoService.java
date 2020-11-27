package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Produto;
import br.com.fatec.quitanda.quitanda.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Produto listarProduto(long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado!!"));
    }

    public Produto cadastrarProduto(Produto produto) {
        return repository.save(produto);
    }

    public void deletarProduto(long id) {
        repository.deleteById(id);
    }

    public Produto alterarProduto(long id, Produto produto) {
        Optional<Produto> p = repository.findById(id);
        if (p.isPresent()) {
            p.get().setNomeProduto(produto.getNomeProduto());
            p.get().setPreco(produto.getPreco());
        }
        return repository.save(p.get());
    }
}

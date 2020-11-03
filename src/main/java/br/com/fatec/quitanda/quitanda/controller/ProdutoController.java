package br.com.fatec.quitanda.quitanda.controller;

import br.com.fatec.quitanda.quitanda.model.Produto;
import br.com.fatec.quitanda.quitanda.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/produto")

public class ProdutoController {
    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodosProdutos() {
        return ResponseEntity.ok(service.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarProduto(@PathVariable long id) {
        return ResponseEntity.ok(service.listarProduto(id));
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto, UriComponentsBuilder uriBuilder) {
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.cadastrarProduto(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable long id) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable long id, @RequestBody Produto produto) {
        return ResponseEntity.ok(service.alterarProduto(id, produto));
    }
}

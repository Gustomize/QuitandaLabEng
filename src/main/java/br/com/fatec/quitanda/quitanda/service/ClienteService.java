package br.com.fatec.quitanda.quitanda.service;


import br.com.fatec.quitanda.quitanda.model.Cliente;
import br.com.fatec.quitanda.quitanda.model.Produto;
import br.com.fatec.quitanda.quitanda.repository.ClienteRepository;
import br.com.fatec.quitanda.quitanda.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    public Cliente listarCleinte(int id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado!!"));
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deletarCliente(int id) {
        repository.deleteById(id);
    }

    public Cliente alterarCliente(int id, Cliente cliente) {
        Optional<Cliente> cli = repository.findById(id);
        if (cli.isPresent()) {
            cli.get().setNomeCliente(cliente.getNomeCliente());
            cli.get().setEndereco(cliente.getEndereco());
        }
        return repository.save(cli.get());
    }
}

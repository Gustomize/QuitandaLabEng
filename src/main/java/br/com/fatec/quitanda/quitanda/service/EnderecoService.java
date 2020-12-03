package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Endereco;
import br.com.fatec.quitanda.quitanda.model.Produto;
import br.com.fatec.quitanda.quitanda.repository.EnderecoRepository;
import br.com.fatec.quitanda.quitanda.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {
    private final EnderecoRepository repository;

    public List<Endereco> listarEnderecos() {
        return repository.findAll();
    }

    public Endereco listarEndereco(int id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Endereco não encontrado!!"));
    }

    public Endereco cadastrarEndereco(Endereco endereco) {
        return repository.save(endereco);
    }

    public void deletarEndereco(int id) {
        repository.deleteById(id);
    }

    public Endereco alterarEndereco(int id, Endereco endereco) {
        Optional<Endereco> e = repository.findById(id);
        if (e.isPresent()) {
            e.get().setLogradouro(endereco.getLogradouro());
            e.get().setBairro(endereco.getBairro());
            e.get().setCep(endereco.getCep());
            e.get().setComplemento(endereco.getComplemento());
            e.get().setCidade(endereco.getCidade());
            e.get().setUf(endereco.getUf());
            e.get().setNumero(endereco.getNumero());

        }
        return repository.save(e.get());
    }
}

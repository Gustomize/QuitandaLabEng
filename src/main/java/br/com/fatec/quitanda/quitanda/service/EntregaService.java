package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Entrega;
import br.com.fatec.quitanda.quitanda.model.Produto;
import br.com.fatec.quitanda.quitanda.repository.EntregaRepository;
import br.com.fatec.quitanda.quitanda.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class EntregaService {
    private final EntregaRepository repository;

    public List<Entrega> listarEntregas() {
        return repository.findAll();
    }

    public Entrega listarEntrega(int id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Entrega não encontrada!!"));
    }

    public Entrega cadastrarEntrega(Entrega entrega) {
        return repository.save(entrega);
    }

    public void deletarEntrega(int id) {
        repository.deleteById(id);
    }

    public Entrega alterarEntrega(int id, Entrega entrega) {
        Optional<Entrega> ent = repository.findById(id);
        if (ent.isPresent()) {
            ent.get().setEndereco(entrega.getEndereco());
            ent.get().setTipoEntrega(entrega.getTipoEntrega());
            ent.get().setPedido(entrega.getPedido());
        }
        return repository.save(ent.get());
    }
}

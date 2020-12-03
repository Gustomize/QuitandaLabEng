package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Perfil;
import br.com.fatec.quitanda.quitanda.model.TipoEntrega;
import br.com.fatec.quitanda.quitanda.repository.TipoEntregaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class TipoEntregaService {
    private final TipoEntregaRepository repository;

    public List<TipoEntrega> listarTiposdeEntrega() {
        return repository.findAll();
    }

    public TipoEntrega listarTipoEntrega(long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Tipo de entrega não encontrado!!"));
    }

    public TipoEntrega cadastrarTipoEntrega(TipoEntrega tipoEntrega) {
        return repository.save(tipoEntrega);
    }

    public void deletarTipoEntrega(long id) {
        repository.deleteById(id);
    }

    public TipoEntrega alterarPerfil(long id, TipoEntrega tipoEntrega) {
        Optional<TipoEntrega> tpEnt = repository.findById(id);
        if (tpEnt.isPresent()) {
            tpEnt.get().setPrazo(tipoEntrega.getPrazo());
            tpEnt.get().setPrecoEntrega(tipoEntrega.getPrecoEntrega());
        }
        return repository.save(tpEnt.get());
    }
}

package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Perfil;
import br.com.fatec.quitanda.quitanda.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PerfilService {
    private final PerfilRepository repository;

    public List<Perfil> listarPerfis() {
        return repository.findAll();
    }

    public Perfil listarPerfil(long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Perfil não encontrado!!"));
    }

    public Perfil cadastrarPerfil(Perfil perfil) {
        return repository.save(perfil);
    }

    public void deletarPerfil(long id) {
        repository.deleteById(id);
    }

    public Perfil alterarPerfil(long id, Perfil perfil) {
        Optional<Perfil> perf = repository.findById(id);
        if (perf.isPresent()) {
            perf.get().setNome(perfil.getNome());
        }
        return repository.save(perf.get());
    }

}

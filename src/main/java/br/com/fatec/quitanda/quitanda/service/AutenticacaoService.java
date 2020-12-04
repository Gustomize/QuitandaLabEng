package br.com.fatec.quitanda.quitanda.service;

import br.com.fatec.quitanda.quitanda.model.Cliente;
import br.com.fatec.quitanda.quitanda.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutenticacaoService implements UserDetailsService {
    private final ClienteRepository clienteRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}

package br.com.fatec.quitanda.quitanda.service;


import br.com.fatec.quitanda.quitanda.model.Pedido;
import br.com.fatec.quitanda.quitanda.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PedidoService {
    private final PedidoRepository repository;

    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }

    public Pedido listarPedido(long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado!!"));
    }

    public Pedido cadastrarPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public void deletarPedido(long id) {
        repository.deleteById(id);
    }

    public Pedido alterarPedido(long id, Pedido pedido) {
        Optional<Pedido> ped = repository.findById(id);
        if (ped.isPresent()) {
            ped.get().setCliente(pedido.getCliente());
        }
        return repository.save(ped.get());
    }
}

package br.com.fatec.quitanda.quitanda.controller;


import br.com.fatec.quitanda.quitanda.repository.PedidoRepository;
import br.com.fatec.quitanda.quitanda.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService service;
}

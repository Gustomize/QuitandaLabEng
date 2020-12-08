package br.com.fatec.quitanda.quitanda.controller;


import br.com.fatec.quitanda.quitanda.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/tipo-entrega")
public class ClienteController {
    private final ClienteService service;
}

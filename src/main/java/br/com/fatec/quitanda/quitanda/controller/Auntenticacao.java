package br.com.fatec.quitanda.quitanda.controller;

import br.com.fatec.quitanda.quitanda.dto.Login;
import br.com.fatec.quitanda.quitanda.dto.Token;
import br.com.fatec.quitanda.quitanda.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/login")

public class Auntenticacao {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    @PostMapping
    public ResponseEntity<Token> autenticar (@RequestBody Login login) {
        UsernamePasswordAuthenticationToken dadosLogin = login.converter();

        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String tokenGerado = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new Token(tokenGerado, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

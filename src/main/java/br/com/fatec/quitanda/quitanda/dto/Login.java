package br.com.fatec.quitanda.quitanda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Getter
@Setter
public class Login {
    private String email;
    private String senha;

    public UsernamePasswordAuthenticationToken converter () {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }

}

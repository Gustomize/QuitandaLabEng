package br.com.fatec.quitanda.quitanda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Token {
    private String token;
    private String tipo;
}

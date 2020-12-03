package br.com.fatec.quitanda.quitanda.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ErroDeFormulario {
    private String campo;
    private String erro;
}

package br.com.fatec.quitanda.quitanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cep;
    private String logradouro;
    private String bairro;
    private String complemento;
    private int numero;
    private String cidade;
    private String uf;
}

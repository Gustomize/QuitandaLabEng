package br.com.fatec.quitanda.quitanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrega;
    @OneToOne(cascade = CascadeType.ALL)
    private Pedido pedido;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    private TipoEntrega tipoEntrega;
}

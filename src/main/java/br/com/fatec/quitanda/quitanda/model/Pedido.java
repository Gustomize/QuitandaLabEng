package br.com.fatec.quitanda.quitanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedido;
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL)
    private Entrega entrega;
    private double precoTotal;
    @OneToMany(mappedBy = "pedido")
    private Set<Carrinho> carrinho;
}

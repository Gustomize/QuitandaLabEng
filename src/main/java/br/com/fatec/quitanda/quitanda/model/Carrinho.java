package br.com.fatec.quitanda.quitanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carrinho {
    @EmbeddedId
    private ProdutoPedidoId id;
    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;
    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;
    private int quantidade;
}

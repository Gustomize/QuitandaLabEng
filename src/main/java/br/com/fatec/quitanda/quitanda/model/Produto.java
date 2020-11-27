package br.com.fatec.quitanda.quitanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;
    private String nomeProduto;
    private String descricao;
    private double preco;
    private Date validade;
    @OneToMany(mappedBy = "produto")
    private Set<Carrinho> carrinho;
}

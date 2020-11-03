package br.com.fatec.quitanda.quitanda.repository;

import br.com.fatec.quitanda.quitanda.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

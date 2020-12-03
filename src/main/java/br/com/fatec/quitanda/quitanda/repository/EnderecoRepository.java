package br.com.fatec.quitanda.quitanda.repository;

import br.com.fatec.quitanda.quitanda.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}

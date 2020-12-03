package br.com.fatec.quitanda.quitanda.repository;

import br.com.fatec.quitanda.quitanda.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
}

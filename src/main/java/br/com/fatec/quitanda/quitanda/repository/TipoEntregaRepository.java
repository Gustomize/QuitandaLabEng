package br.com.fatec.quitanda.quitanda.repository;

import br.com.fatec.quitanda.quitanda.model.TipoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEntregaRepository extends JpaRepository<TipoEntrega, Long> {
}

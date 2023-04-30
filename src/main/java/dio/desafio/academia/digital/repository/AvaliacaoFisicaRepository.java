package dio.desafio.academia.digital.repository;

import dio.desafio.academia.digital.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {


}
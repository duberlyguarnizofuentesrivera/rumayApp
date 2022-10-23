package edu.utp.rumay.repository;

import edu.utp.rumay.enums.TipoRegistro;
import edu.utp.rumay.model.RegistroClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistroClinicoRepository extends JpaRepository<RegistroClinico, Long> {
    List<RegistroClinico> findByTipoRegistro(TipoRegistro tipoRegistro);

    List<RegistroClinico> findByRecetaEmitidaIsTrue();

    List<RegistroClinico> findByFechaCreadoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}

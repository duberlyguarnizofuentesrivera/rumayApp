package edu.utp.rumay.repository;

import edu.utp.rumay.enums.TipoComprobante;
import edu.utp.rumay.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByTipoComprobante(TipoComprobante tipoComprobante);

    List<Pago> findByNumeroComprobante(String numeroComprobante);

    List<Pago> findByFechaCreadoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}

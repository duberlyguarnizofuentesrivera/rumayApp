package edu.utp.rumay.controller;

import edu.utp.rumay.enums.TipoComprobante;
import edu.utp.rumay.model.Pago;
import edu.utp.rumay.repository.PagoRepository;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PagoController {
    private final PagoRepository pagoRepository;

    public PagoController(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    //CRUD methods
    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void eliminarPago(Pago pago) {
        pagoRepository.delete(pago);
    }

    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }

    public Pago obtenerPago(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    public List<Pago> obtenerPagosPorTipoComprobante(TipoComprobante tipoComprobante) {
        return pagoRepository.findByTipoComprobante(tipoComprobante);
    }

    public List<Pago> obtenerPagosPorNumeroComprobante(String numeroComprobante) {
        return pagoRepository.findByNumeroComprobante(numeroComprobante);
    }

    public List<Pago> obtenerPagosPorFecha(LocalDate fecha) {
        return pagoRepository.findByFechaCreadoBetween(fecha.atStartOfDay(), fecha.plusDays(1).atStartOfDay());
    }

    public List<Pago> obtenerPagosPorFechaEntre(LocalDate fechaInicio, LocalDate fechaFin) {
        return pagoRepository.findByFechaCreadoBetween(fechaInicio.atStartOfDay(), fechaFin.plusDays(1).atStartOfDay());
    }

}

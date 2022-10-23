package edu.utp.rumay.controller;

import edu.utp.rumay.model.Cita;
import edu.utp.rumay.model.Pago;
import edu.utp.rumay.repository.CitaRepository;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class CitaController {

    private final CitaRepository citaRepository;

    public CitaController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita crearCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public void eliminarCita(Cita cita) {
        citaRepository.delete(cita);
    }

    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }

    public Cita obtenerCita(Long id) {
        return citaRepository.findById(id).orElse(null);
    }
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public List<Cita> obtenerCitasPorUsuario(Long usuarioId) {
        return citaRepository.findByUsuario_Id(usuarioId);
    }

    public Pago obtenerPagoDeCita(Long citaId) {
        Optional<Cita> cita = citaRepository.findById(citaId);
        return cita.map(Cita::getPago).orElse(null);
    }

    public List<Cita> obtenerCitasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return citaRepository.findByFechaHoraBetween(fechaInicio.atStartOfDay(), fechaFin.plusDays(1).atStartOfDay());
    }
}

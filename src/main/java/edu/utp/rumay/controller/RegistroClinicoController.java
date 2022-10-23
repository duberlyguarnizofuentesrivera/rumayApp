package edu.utp.rumay.controller;

import edu.utp.rumay.enums.TipoRegistro;
import edu.utp.rumay.model.RegistroClinico;
import edu.utp.rumay.repository.RegistroClinicoRepository;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RegistroClinicoController {
    private final RegistroClinicoRepository registroClinicoRepository;

    public RegistroClinicoController(RegistroClinicoRepository registroClinicoRepository) {
        this.registroClinicoRepository = registroClinicoRepository;
    }

    //CRUD methods
    public RegistroClinico crearRegistroClinico(RegistroClinico registroClinico) {
        return registroClinicoRepository.save(registroClinico);
    }

    public RegistroClinico actualizarRegistroClinico(RegistroClinico registroClinico) {
        return registroClinicoRepository.save(registroClinico);
    }

    public void eliminarRegistroClinico(RegistroClinico registroClinico) {
        registroClinicoRepository.delete(registroClinico);
    }

    public void eliminarRegistroClinico(Long id) {
        registroClinicoRepository.deleteById(id);
    }

    public RegistroClinico buscarRegistroClinico(Long id) {
        return registroClinicoRepository.findById(id).orElse(null);
    }

    public List<RegistroClinico> listarRegistrosClinicos() {
        return registroClinicoRepository.findAll();
    }

    public List<RegistroClinico> buscarRegistrosClinicoPorTipo(TipoRegistro tipoRegistro) {
        return registroClinicoRepository.findByTipoRegistro(tipoRegistro);
    }

    public List<RegistroClinico> buscarRegistrosClinicoPorRecetaEmitida() {
        return registroClinicoRepository.findByRecetaEmitidaIsTrue();
    }

    public List<RegistroClinico> buscarRegistrosClinicoPorFecha(LocalDate fecha) {
        return registroClinicoRepository.findByFechaCreadoBetween(fecha.atStartOfDay(), fecha.plusDays(1).atStartOfDay());
    }

    public List<RegistroClinico> buscarRegistrosClinicoPorFechaEntre(LocalDate fechaInicio, LocalDate fechaFin) {
        return registroClinicoRepository.findByFechaCreadoBetween(fechaInicio.atStartOfDay(), fechaFin.plusDays(1).atStartOfDay());
    }

}

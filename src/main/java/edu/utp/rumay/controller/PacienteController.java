package edu.utp.rumay.controller;

import edu.utp.rumay.enums.Genero;
import edu.utp.rumay.model.Paciente;
import edu.utp.rumay.repository.PacienteRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PacienteController {
    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //CRUD methods
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente obtenerPaciente(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public List<Paciente> obtenerPacientesPorNombre(String nombre) {
        return pacienteRepository.findByNombres(nombre);
    }

    public List<Paciente> obtenerPacientesPorGenero(Genero genero) {
        return pacienteRepository.findByGenero(genero);
    }

    public List<Paciente> obtenerPacientesPorNacimiento(int nacimiento) {
        return pacienteRepository.findByNacimiento(nacimiento);
    }

    public List<Paciente> obtenerPacientesPorNacimientoEntre(int nacimiento1, int nacimiento2) {
        return pacienteRepository.findByNacimientoBetween(nacimiento1, nacimiento2);
    }

}

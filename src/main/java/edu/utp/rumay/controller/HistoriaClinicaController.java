package edu.utp.rumay.controller;

import edu.utp.rumay.model.HistoriaClinica;
import edu.utp.rumay.repository.HistoriaClinicaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HistoriaClinicaController {
    private final HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinicaController(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    //CRUD methods

    public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    public HistoriaClinica actualizarHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void eliminarHistoriaClinica(HistoriaClinica historiaClinica) {
        historiaClinicaRepository.delete(historiaClinica);
    }

    public void eliminarHistoriaClinica(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    public HistoriaClinica obtenerHistoriaClinica(Long id) {
        return historiaClinicaRepository.findById(id).orElse(null);
    }
    public List<HistoriaClinica> listarHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    public HistoriaClinica obtenerHistoriaClinicaPorPaciente(String dni) {
        //El repositorio devuelve una lista de historias clínicas cuando usa
        //la forma findBy()... pero como sabemos que solo puede haber una
        //historia clínica por paciente, entonces solo nos interesa el primer elemento
        var hc = historiaClinicaRepository.findByPaciente_Dni(dni);
        if (hc.size() == 0) {
            return null;
        }
        return hc.get(0);
    }
}

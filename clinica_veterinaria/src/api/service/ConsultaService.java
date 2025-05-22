package api.service;

import api.model.Animal;
import api.model.Consulta;
import api.repository.impl.ConsultaRepository;

import java.util.ArrayList;
import java.util.List;

public class ConsultaService extends BaseService<Consulta> {
    private final ConsultaRepository consultaRepository = new ConsultaRepository();

    @Override
    public Consulta save(Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não pode ser nula.");
        }

        if (consulta.getAnimal() == null) {
            throw new IllegalArgumentException("Animal da consulta é obrigatório.");
        }

        if (consulta.getServico() == null) {
            throw new IllegalArgumentException("Serviço da consulta é obrigatório.");
        }

        if (consulta.getDataHora() == null) {
            throw new IllegalArgumentException("Data e hora são obrigatórias.");
        }

        if (consulta.getStatus() == null || consulta.getStatus().isBlank()) {
            consulta.setStatus("AGENDADA");
        }

        Consulta novaConsulta = consultaRepository.save(consulta);

        Animal animal = novaConsulta.getAnimal();
        animal.getListaDeConsultas().add(novaConsulta);

        return novaConsulta;
    }

    @Override
    public Consulta findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        Consulta consulta = consultaRepository.findById(id);
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta com ID " + id + " não encontrada.");
        }

        return consulta;
    }

    @Override
    public List<Consulta> findAll() {
        return new ArrayList<>(consultaRepository.findAll().values());
    }

    @Override
    public void delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        Consulta consulta = consultaRepository.findById(id);
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta com ID " + id + " não encontrada.");
        }

        consulta.getAnimal().getListaDeConsultas().remove(consulta);

        consultaRepository.delete(id);
    }

    public Consulta update(int id, Consulta novaConsulta) {
        Consulta consulta = consultaRepository.findById(id);
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta com ID " + id + " não encontrada.");
        }

        if (novaConsulta.getDataHora() != null) {
            consulta.setDataHora(novaConsulta.getDataHora());
        }

        if (novaConsulta.getStatus() != null && !novaConsulta.getStatus().isBlank()) {
            consulta.setStatus(novaConsulta.getStatus());
        }

        if (novaConsulta.getServico() != null) {
            consulta.setServico(novaConsulta.getServico());
        }

        return consulta;
    }
}

package api.controller;

import api.model.Consulta;
import api.service.ConsultaService;

import java.util.List;

public class ConsultaController extends BaseController<Consulta> {
    private final ConsultaService consultaService = new ConsultaService();

    @Override
    public Consulta save(Consulta consulta) {
        try {
            Consulta salva = consultaService.save(consulta);
            System.out.println("Consulta salva com sucesso! ID: " + salva.getId());
            return salva;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao salvar consulta: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Consulta findById(int id) {
        try {
            Consulta consulta = consultaService.findById(id);
            System.out.println("Consulta encontrada: " + consulta);
            return consulta;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao busar consulta: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Consulta> findAll() {
        List<Consulta> consultas = consultaService.findAll();
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
            return List.of();
        }

        System.out.println("Consultas cadastradas:");
        consultas.forEach(System.out::println);
        return consultas;
    }

    @Override
    public void delete(int id) {
        try {
            consultaService.delete(id);
            System.out.println("Consulta deletada com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao deletar consulta: " + e.getMessage());
        }
    }

    public Consulta update(int id, Consulta novaConsulta) {
        try {
            Consulta consulta = consultaService.update(id, novaConsulta);
            System.out.println("Consulta atualizada com sucesso: " + consulta);
            return consulta;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar consulta: " + e.getMessage());
            return null;
        }
    }
}
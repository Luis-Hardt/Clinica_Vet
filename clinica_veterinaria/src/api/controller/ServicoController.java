package api.controller;

import api.model.Servico;
import api.service.ServicoService;

import java.util.List;
import java.util.Map;

public class ServicoController extends BaseController<Servico> {
    private final ServicoService servicoService = new ServicoService();

    @Override
    public Servico save(Servico servico) {
        try {
            Servico novoServico = servicoService.save(servico);
            System.out.println("Serviço cadastrado com sucesso! ID: " + novoServico.getId());
            return novoServico;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao salvar serviço: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Servico findById(int id) {
        try {
            Servico servico = servicoService.findById(id);
            System.out.println("Serviço encontrado: " + servico);
            return servico;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao buscar serviço: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Servico> findAll() {
        List<Servico> servicos = servicoService.findAll();
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            return List.of();
        }

        System.out.println("Serviços cadastrados:");
        servicos.forEach(System.out::println);
        return servicos;
    }


    @Override
    public void delete(int id) {
        try {
            servicoService.delete(id);
            System.out.println("Serviço excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao excluir serviço: " + e.getMessage());
        }
    }

    public Servico update(int id, Servico servicoAtualizado) {
        try {
            Servico servico = servicoService.update(id, servicoAtualizado);
            System.out.println("Serviço atualizado com sucesso: " + servico);
            return servico;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar serviço: " + e.getMessage());
            return null;
        }
    }
}

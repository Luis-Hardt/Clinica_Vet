package api.service;

import api.model.Servico;
import api.repository.impl.ServicoRepository;

import java.util.ArrayList;
import java.util.List;

public class ServicoService extends BaseService<Servico> {
    private final ServicoRepository servicoRepository = new ServicoRepository();

    @Override
    public Servico save(Servico servico) {
        if (servico == null) {
            throw new IllegalArgumentException("Serviço não pode ser nulo.");
        }

        if (servico.getNome() == null || servico.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do serviço é obrigatório.");
        }

        if (servico.getPreco() < 0) {
            throw new IllegalArgumentException("Preço do serviço não pode ser negativo.");
        }

        if (servico.getDescricao() == null || servico.getDescricao().isBlank()) {
            servico.setDescricao("Sem descrição.");
        }

        return servicoRepository.save(servico);
    }


    @Override
    public Servico findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        Servico servico = servicoRepository.findById(id);
        if (servico == null) {
            throw new IllegalArgumentException("Serviço com ID " + id + " não encontrado.");
        }

        return servico;
    }


    @Override
    public List<Servico> findAll() {
        return new ArrayList<>(servicoRepository.findAll().values());
    }

    @Override
    public void delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        Servico servico = servicoRepository.findById(id);
        if (servico == null) {
            throw new IllegalArgumentException("Serviço com ID " + id + " não encontrado.");
        }

        servicoRepository.delete(id);
    }

    public Servico update(int id, Servico novoServico) {
        Servico servico = servicoRepository.findById(id);
        if (servico == null) {
            throw new IllegalArgumentException("Serviço com ID " + id + " não encontrado.");
        }

        if (novoServico.getNome() != null && !novoServico.getNome().isBlank()) {
            servico.setNome(novoServico.getNome());
        }

        if (novoServico.getDescricao() != null && !novoServico.getDescricao().isBlank()) {
            servico.setDescricao(novoServico.getDescricao());
        }

        if (novoServico.getPreco() >= 0) {
            servico.setPreco(novoServico.getPreco());
        }

        return servico;
    }
}
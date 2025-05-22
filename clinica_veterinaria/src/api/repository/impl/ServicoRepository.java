package api.repository.impl;

import api.model.Servico;
import api.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class ServicoRepository implements Repository<Servico> {
    private final Map<Integer, Servico> servicoMap = new HashMap<>();
    private int nextId = 1;

    @Override
    public Servico save(Servico servico) {
        servico.setId(nextId++);
        servicoMap.put(servico.getId(), servico);
        return servico;
    }

    @Override
    public Servico findById(int id) {
        return servicoMap.get(id);
    }

    @Override
    public Map<Integer, Servico> findAll() {
        return servicoMap;
    }

    @Override
    public void delete(int id) {
        servicoMap.remove(id);
    }
}

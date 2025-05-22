package api.repository.impl;

import api.model.Consulta;
import api.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class ConsultaRepository implements Repository<Consulta> {
    private final Map<Integer, Consulta> consultaMap = new HashMap<>();
    private int nextId = 1;

    @Override
    public Consulta save(Consulta consulta) {
        consulta.setId(nextId++);
        consultaMap.put(consulta.getId(), consulta);
        return consulta;
    }

    @Override
    public Consulta findById(int id) {
        return consultaMap.get(id);
    }

    @Override
    public Map<Integer, Consulta> findAll() {
        return consultaMap;
    }

    @Override
    public void delete(int id) {
        consultaMap.remove(id);
    }
}

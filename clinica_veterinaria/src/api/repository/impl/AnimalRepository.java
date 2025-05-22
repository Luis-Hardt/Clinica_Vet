package api.repository.impl;

import api.model.Animal;
import api.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class AnimalRepository implements Repository<Animal> {
    private final Map<Integer, Animal> animapMap = new HashMap<>();
    private int nextId = 1;

    @Override
    public Animal save(Animal animal) {
        animal.setId(nextId++);
        animapMap.put(animal.getId(), animal);
        return animal;
    }

    @Override
    public Animal findById(int id) {
        return animapMap.get(id);
    }

    @Override
    public Map<Integer, Animal> findAll() {
        return animapMap;
    }

    @Override
    public void delete(int id) {
        animapMap.remove(id);
    }
}

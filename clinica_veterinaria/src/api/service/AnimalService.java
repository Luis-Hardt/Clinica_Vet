package api.service;

import api.model.Animal;
import api.model.Consulta;
import api.repository.impl.AnimalRepository;

import java.util.ArrayList;
import java.util.List;

public class AnimalService extends BaseService<Animal> {
    private final AnimalRepository animalRepository = new AnimalRepository();

    @Override
    public Animal save(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal não pode ser nulo.");
        }

        if (animal.getNome() == null || animal.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do animal é obrigatório.");
        }

        if (animal.getEspecie() == null || animal.getEspecie().isBlank()) {
            throw new IllegalArgumentException("Espécie do animal é obrigatória.");
        }

        if (animal.getNomeDoDono() == null || animal.getNomeDoDono().isBlank()) {
            throw new IllegalArgumentException("Nome do dono é obrigatório.");
        }

        return animalRepository.save(animal);
    }

    @Override
    public Animal findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        Animal animal = animalRepository.findById(id);
        if (animal == null) {
            throw new IllegalArgumentException("Animal com ID " + id + " não encontrado.");
        }

        return animal;
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(animalRepository.findAll().values());
    }

    @Override
    public void delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        if (animalRepository.findById(id) == null) {
            throw new IllegalArgumentException("Animal com ID " + id + " não encontrado.");
        }

        animalRepository.delete(id);
    }

    public Animal update(int id, Animal novoAnimal) {
        Animal animal = animalRepository.findById(id);
        if (animal == null) {
            throw new IllegalArgumentException("Animal com ID " + id + " não encontrado.");
        }

        if (novoAnimal.getNome() != null && !novoAnimal.getNome().isBlank()) {
            animal.setNome(novoAnimal.getNome());
        }

        if (novoAnimal.getEspecie() != null && !novoAnimal.getEspecie().isBlank()) {
            animal.setEspecie(novoAnimal.getEspecie());
        }

        if (novoAnimal.getNomeDoDono() != null && !novoAnimal.getNomeDoDono().isBlank()) {
            animal.setNomeDoDono(novoAnimal.getNomeDoDono());
        }

        return animal;
    }
}

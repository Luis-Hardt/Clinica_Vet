package api.controller;

import api.model.Animal;
import api.model.Consulta;
import api.service.AnimalService;

import java.util.List;

public class AnimalController extends BaseController<Animal> {
    private final AnimalService animalService = new AnimalService();

    @Override
    public Animal save(Animal animal) {
        try {
            Animal novoAnimal = animalService.save(animal);
            System.out.println("Animal cadastrado com sucesso! ID: " + novoAnimal.getId());
            return novoAnimal;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar animal: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Animal findById(int id) {
        try {
            Animal animal = animalService.findById(id);
            System.out.println("Animal encontrado: " + animal);
            return animal;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao buscar animal: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> animais = animalService.findAll();
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return List.of();
        }

        System.out.println("Animais cadastrados:");
        animais.forEach(System.out::println);
        return animais;
    }


    @Override
    public void delete(int id) {
        try {
            animalService.delete(id);
            System.out.println("Animal excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao excluir animal: " + e.getMessage());
        }
    }

    public Animal update(int id, Animal novoAnimal) {
        try {
            Animal animal = animalService.update(id, novoAnimal);
            System.out.println("Animal atualizado com sucesso: " + animal);
            return animal;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar animal: " + e.getMessage());
            return null;
        }
    }
}

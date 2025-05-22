package app.ui;

import api.controller.AnimalController;
import api.model.Animal;
import app.menu.InputReader;

import java.util.List;

public class AnimalUI implements EntityUI {
    private final InputReader input = new InputReader();
    private final AnimalController controller;

    public AnimalUI(AnimalController controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("\n=== MENU DE ANIMAIS ===");
            System.out.println("1. Listar animais");
            System.out.println("2. Cadastrar animal");
            System.out.println("3. Atualizar animal");
            System.out.println("4. Remover animal");
            System.out.println("0. Voltar");

            int option = input.readInt("Escolha uma opção");

            switch (option) {
                case 1 -> listar();
                case 2 -> cadastrar();
                case 3 -> atualizar();
                case 4 -> remover();
                case 0 -> {
                    System.out.println("Voltando...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void listar() {
        List<Animal> animais = controller.findAll();
    }

    private void cadastrar() {
        String nome = input.readLine("Nome do animal");
        String especie = input.readLine("Espécie");
        String nomeDoDono = input.readLine("Nome do dono(a)");

        Animal animal = new Animal(nome, especie, nomeDoDono);

        controller.save(animal);
    }

    private void atualizar() {
        int id = input.readInt("ID do animal a atualizar");

        Animal animal = controller.findById(id);
        if (animal == null) {
            return;
        }

        System.out.println("(Pressione ENTER caso não queira alterar algum campo)");
        String novoNome = input.readLine("Nome");
        String novaEspecie = input.readLine("Espécie");
        String novoDono = input.readLine("Nome do dono(a)");

        Animal novoAnimal = new Animal(
                novoNome.isBlank() ? animal.getNome() : novoNome,
                novaEspecie.isBlank() ? animal.getEspecie() : novaEspecie,
                novoDono.isBlank() ? animal.getNomeDoDono() : novoDono
        );

        controller.update(id, novoAnimal);
    }

    private void remover() {
        int id = input.readInt("ID do animal a remover");

        controller.delete(id);
    }
}
package app.ui;

import api.controller.ConsultaController;
import api.controller.AnimalController;
import api.controller.ServicoController;
import api.model.Animal;
import api.model.Consulta;
import api.model.Servico;
import app.menu.InputReader;

import java.time.LocalDateTime;
import java.util.List;

public class ConsultaUI implements EntityUI {
    private final InputReader input = new InputReader();
    private final ConsultaController controller;
    private final AnimalController animalController;
    private final ServicoController servicoController;

    public ConsultaUI(ConsultaController controller, AnimalController animalController, ServicoController servicoController) {
        this.controller = controller;
        this.animalController = animalController;
        this.servicoController = servicoController;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("\n=== MENU DE CONSULTAS ===");
            System.out.println("1. Listar consultas");
            System.out.println("2. Cadastrar consulta");
            System.out.println("3. Atualizar consulta");
            System.out.println("4. Remover consulta");
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
        List<Consulta> consultas = controller.findAll();
    }

    private void cadastrar() {
        int animalId = input.readInt("ID do animal");
        Animal animal = animalController.findById(animalId);
        if (animal == null) {
            return;
        }

        int servicoId = input.readInt("ID do serviço");
        Servico servico = servicoController.findById(servicoId);
        if (servico == null) {
            return;
        }

        LocalDateTime dataHora = input.readDateTime("Data e hora da consulta");
        String status = input.readLine("Status da consulta");

        Consulta consulta = new Consulta(animal, dataHora, status, servico);

        controller.save(consulta);
    }

    private void atualizar() {
        int id = input.readInt("ID da consulta a atualizar");

        Consulta consulta = controller.findById(id);
        if (consulta == null) {
            return;
        }

        System.out.println("(Pressione ENTER caso não queira alterar algum campo)");
        String novoStatus = input.readLine("Status");

        Consulta novaConsulta = new Consulta(
                null,
                null,
                novoStatus.isBlank() ? consulta.getStatus() : novoStatus,
                null
        );

        controller.update(id, novaConsulta);
    }

    private void remover() {
        int id = input.readInt("ID da consulta a remover");

        controller.delete(id);
    }
}
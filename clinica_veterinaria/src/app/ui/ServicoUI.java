package app.ui;

import api.controller.ServicoController;
import api.model.Servico;
import app.menu.InputReader;

import java.util.List;

public class ServicoUI implements EntityUI {
    private final InputReader input = new InputReader();
    private final ServicoController controller;

    public ServicoUI(ServicoController controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("\n=== MENU DE SERVIÇOS ===");
            System.out.println("1. Listar serviços");
            System.out.println("2. Cadastrar serviço");
            System.out.println("3. Atualizar serviço");
            System.out.println("4. Remover serviço");
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
        List<Servico> servicos = controller.findAll();
    }

    private void cadastrar() {
        String nome = input.readLine("Nome do serviço");
        String descricao = input.readLine("Descrição");
        double preco = input.readDouble("Preço do serviço");

        Servico servico = new Servico(nome, descricao, preco);

        controller.save(servico);
    }

    private void atualizar() {
        int id = input.readInt("ID do serviço a atualizar");

        Servico servico = controller.findById(id);
        if (servico == null) {
            return;
        }

        System.out.println("(Pressione ENTER caso não queira alterar algum campo)");
        String novoNome = input.readLine("Nome");
        String novaDescricao = input.readLine("Descrição");
        Double novoPreco = input.readOptionalDouble("Preço");

        Servico novoServico = new Servico(
                novoNome.isBlank() ? servico.getNome() : novoNome,
                novaDescricao.isBlank() ? servico.getDescricao() : novaDescricao,
                novoPreco == null ? servico.getPreco() : novoPreco
        );

        controller.update(id, novoServico);
    }

    private void remover() {
        int id = input.readInt("ID do serviço a remover");

        controller.delete(id);
    }
}

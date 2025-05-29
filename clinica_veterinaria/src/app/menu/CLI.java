package app.menu;

import app.AppContext;
import app.ui.AnimalUI;
import app.ui.ConsultaUI;
import app.ui.ServicoUI;

public class CLI {

    private final InputReader inputReader;
    private final ServicoUI servicoUI;
    private final AnimalUI animalUI;
    private final ConsultaUI consultaUI;

    public CLI() {
        this.inputReader = new InputReader();

        AppContext context = new AppContext();

        this.servicoUI = new ServicoUI(context.getServicoController());
        this.animalUI = new AnimalUI(context.getAnimalController());
        this.consultaUI = new ConsultaUI(
                context.getConsultaController(),
                context.getAnimalController(),
                context.getServicoController()
        );
    }

    public void start() {
        while (true) {
            System.out.println("\n=== SISTEMA DE CLINICA VETERINARIA ===");
            System.out.println("1. Gerenciar Serviços");
            System.out.println("2. Gerenciar Animais");
            System.out.println("3. Gerenciar Consultas");
            System.out.println("0. Sair");

            int opcao = inputReader.readInt("Escolha uma opção");

            switch (opcao) {
                case 1 -> servicoUI.start();
                case 2 -> animalUI.start();
                case 3 -> consultaUI.start();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

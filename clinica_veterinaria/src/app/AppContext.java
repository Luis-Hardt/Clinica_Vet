package app;

import api.controller.AnimalController;
import api.controller.ConsultaController;
import api.controller.ServicoController;

public class AppContext {
    private final AnimalController animalController = new AnimalController();
    private final ConsultaController consultaController = new ConsultaController();
    private final ServicoController servicoController = new ServicoController();

    public AnimalController getAnimalController() {
        return animalController;
    }

    public ConsultaController getConsultaController() {
        return consultaController;
    }

    public ServicoController getServicoController() {
        return servicoController;
    }
}
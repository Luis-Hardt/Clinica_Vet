package api.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta extends BaseEntity {
    private Animal animal;
    private LocalDateTime dataHora;
    private String status;
    private Servico servico;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Consulta(Animal animal, LocalDateTime dataHora, String status, Servico servico) {
        super();
        this.animal = animal;
        this.dataHora = dataHora;
        this.status = status;
        this.servico = servico;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDataHoraFormatada() {
        return this.dataHora.format(formatter);
    }

    public void setDataHora(String dataHoraStr) {
        this.dataHora = LocalDateTime.parse(dataHoraStr, formatter);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + getId() +
                ", animal='" + getAnimal().getNome() + '\'' +
                ", dataHora='" + getDataHoraFormatada() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", servico='" + getServico().getNome() + '\'' +
                '}';
    }
}
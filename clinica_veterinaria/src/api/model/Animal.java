package api.model;

import java.util.ArrayList;
import java.util.List;

public class Animal extends BaseEntity {
    private String nome;
    private String especie;
    private String nomeDoDono;
    private List<Consulta> listaDeConsultas;

    public Animal(String nome, String especie, String nomeDoDono) {
        super();
        this.nome = nome;
        this.especie = especie;
        this.nomeDoDono = nomeDoDono;
        this.listaDeConsultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNomeDoDono() {
        return nomeDoDono;
    }

    public void setNomeDoDono(String nomeDoDono) {
        this.nomeDoDono = nomeDoDono;
    }

    public List<Consulta> getListaDeConsultas() {
        return listaDeConsultas;
    }

    public void setListaDeConsultas(List<Consulta> listaDeConsultas) {
        this.listaDeConsultas = listaDeConsultas;
    }

    @Override
    public String toString() {
        StringBuilder consultasStr = new StringBuilder();
        for (Consulta consulta : listaDeConsultas) {
            consultasStr.append(consulta.getId()).append(", ");
        }

        String idsConsultas = listaDeConsultas.isEmpty()
                ? "N/A"
                : consultasStr.substring(0, consultasStr.length() - 2);

        return "Animal{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", especie='" + getEspecie() + '\'' +
                ", nomeDoDono='" + getNomeDoDono() + '\'' +
                ", consultas(ids)=[" + idsConsultas + "]" +
                '}';
    }
}

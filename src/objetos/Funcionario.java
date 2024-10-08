package objetos;

import java.util.*;

public class Funcionario {

    private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private String nomeFuncionario;
    private int idFuncionario;
    private String cargoFuncionario;
    private int vendasFuncionario;

    public Funcionario(List<Funcionario> funcionarios, String nomeFuncionario, int idFuncionario, String cargoFuncionario, int vendasFuncionario) {
        this.listaFuncionarios = funcionarios;
        this.nomeFuncionario = nomeFuncionario;
        this.idFuncionario = idFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.vendasFuncionario = vendasFuncionario;
    }

//    public Funcionario(String nomeFuncionario, int idFuncionario, String cargoFuncionario, int vendasFuncionario) {
//        this.nomeFuncionario = nomeFuncionario;
//        this.idFuncionario = idFuncionario;
//        this.cargoFuncionario = cargoFuncionario;
//        this.vendasFuncionario = vendasFuncionario;
//    }

    public Funcionario(String nomeFuncionario, int idFuncionario, String cargoFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.idFuncionario = idFuncionario;
        this.cargoFuncionario = cargoFuncionario;
    }

    public Funcionario() {

    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public int getVendasFuncionario() {
        return vendasFuncionario;
    }

    public void setVendasFuncionario(int vendasFuncionario) {
        this.vendasFuncionario = vendasFuncionario;
    }

    public void addFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    @Override
    public String toString() {
        if (cargoFuncionario != null && cargoFuncionario.equalsIgnoreCase("garcom")) {
            return "Funcionario{" +
                    "nomeFuncionario='" + nomeFuncionario + '\'' +
                    ", idFuncionario='" + idFuncionario + '\'' +
                    ", cargoFuncionario='" + cargoFuncionario + '\'' +
                    ", vendasFuncionario=" + vendasFuncionario +
                    '}';
        } else {
            return "Funcionario{" +
                    "nomeFuncionario='" + nomeFuncionario + '\'' +
                    ", idFuncionario='" + idFuncionario + '\'' +
                    ", cargoFuncionario='" + (cargoFuncionario != null ? cargoFuncionario : "Sem cargo") + '\''+
                    '}';
        }
    }
}
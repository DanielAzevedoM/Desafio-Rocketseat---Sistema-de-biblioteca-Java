package models;

import java.time.LocalDate;

public class Emprestimo {

    private int id;
    private String nomeCliente; 
    private int idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, String nomeCliente, int idLivro, LocalDate dataEmprestimo, 
    LocalDate dataDevolucao){
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
   
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
   
}

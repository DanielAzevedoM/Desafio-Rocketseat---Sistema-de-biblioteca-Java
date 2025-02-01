package models;
import java.time.LocalDate;

public class Livros {

    private int id;
    private String titulo;
    private String autor;
    private boolean disponibilidade;
    private LocalDate dataCadastro;
    private LocalDate dataAtualização;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public boolean getDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public LocalDate getDataAtualização() {
        return dataAtualização;
    }
    public void setDataAtualização(LocalDate dataAtualização) {
        this.dataAtualização = dataAtualização;
    }
}

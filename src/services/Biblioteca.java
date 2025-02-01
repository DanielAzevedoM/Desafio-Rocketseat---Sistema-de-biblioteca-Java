package services;
import java.util.List;

import models.Emprestimo;
import models.Livros;

public abstract class Biblioteca {
    protected abstract void adicionarLivro(List<Livros> livros);
    protected abstract void listarLivrosDisponiveis(List<Livros> list);
    protected abstract void emprestarLivro(List<Livros> livros, List<Emprestimo> emprestimos);
    protected abstract void listarLivrosEmprestados(List<Emprestimo> emprestimos);
    protected abstract void devolverLivro(List<Livros> livros, List<Emprestimo> emprestimos);
}

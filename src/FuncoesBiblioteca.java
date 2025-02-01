import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import models.Autor;
import models.Emprestimo;
import models.Livros;
import services.Biblioteca;

public class FuncoesBiblioteca extends Biblioteca{
    Scanner scanner = new Scanner(System.in);

    @Override
    protected void adicionarLivro(List<Livros> livros) {
        System.out.println("\nAdicionar Livros \n");
        Livros livro = new Livros();
        livro.setId(livros.size()+1);
        System.out.println("Digite o título do seu livro: ");
        String titulo = scanner.nextLine();
        livro.setTitulo(titulo);
        System.out.println("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        livro.setAutor(autor);
        livro.setDisponibilidade(true);
        livro.setDataCadastro(LocalDate.now());
        livro.setDataAtualização(LocalDate.now());
        livros.add(livro);
    }

    @Override
    protected void listarLivrosDisponiveis(List<Livros> livros) {
        System.out.println("\nLivros Disponíveis");
        for(Livros livro : livros){
            if (livro.getDisponibilidade() == true) {
                System.out.println("Id: " + livro.getId() +  "\nTítulo: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nData de cadastro: " 
                + livro.getDataCadastro() + "\nData de Atualização: " + livro.getDataAtualização());    
            }
        }   
    }

    @Override
    protected void emprestarLivro(List<Livros> livros, List<Emprestimo> emprestimos) {
        System.out.println("\nDigite o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o Id do livro que você quer pegar: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < livros.size(); i++) {
            Livros livro = livros.get(i);
            if (livro.getId() == idLivro) {
                if(livro.getDisponibilidade() == false) {
                    System.out.println("O livro já foi emprestado!");
                    break;
                }
                livro.setDisponibilidade(false);
                livro.setDataAtualização(LocalDate.now());
                Emprestimo emprestar = new Emprestimo(emprestimos.size() + 1,nome, idLivro, LocalDate.now(), LocalDate.of(2025, 03, 31));
                emprestimos.add(emprestar);
            }
        }
    }

    @Override
    protected void listarLivrosEmprestados(List<Emprestimo> emprestimos){
        System.out.println("\nLivros Emprestados");
        for(Emprestimo emprestados : emprestimos){
                System.out.println("Id do empréstimo: " + emprestados.getId() +  "\nNome do Cliente: " + emprestados.getNomeCliente() 
                + "\nId do Livro: " + emprestados.getIdLivro() + "\nData do Empréstimo: " + emprestados.getDataEmprestimo() 
                + "\nData para Devolução: " + emprestados.getDataDevolucao());         
        }   
    } 

    protected void devolverLivro(List<Livros> livros, List<Emprestimo> emprestimos){
        System.out.println("\nQual o id do livro que vc quer devolver?");
        int idLivro = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo emprestimo = emprestimos.get(i);
            if (idLivro == emprestimo.getId()) {
                for (int j = 0; j < livros.size(); j++) {
                    Livros livro = livros.get(i);
                    if(livro.getId() == idLivro){
                        livro.setDataAtualização(LocalDate.now());
                        livro.setDisponibilidade(true);
                    }
                }
                emprestimos.remove(emprestimo);
            }
        }
    }

    protected void adicionarAutor(List<Autor> autor){
        Autor novoAutor = new Autor();
        System.out.println("\nDigite o nome do Autor: \n");
        String nome = scanner.nextLine();
        novoAutor.setId(autor.size()+1);
        novoAutor.setNome(nome);
        System.out.println("Digite a data de nascimento do autor: ");
        System.out.print("dia: ");
        int dia = scanner.nextInt();
        scanner.nextLine();
        System.out.print("mês: ");
        int mes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        novoAutor.setDataNascimento(LocalDate.of(ano, mes, dia));
        autor.add(novoAutor);
    }

    protected void pesquisarLivrosDeAutores(List<Autor> autor, List<Livros> livros){
        System.out.println("\n Autores cadastrados: \n");
        for(Autor autorPesquisa: autor){
            System.out.println("Id: " + autorPesquisa.getId());
            System.out.println("Nome: " + autorPesquisa.getNome());
            System.out.println("Nascimento: " + autorPesquisa.getDataNascimento());
        }
        System.out.println("Digite o id do autor que você quer ver livros: ");
        int idAutor = scanner.nextInt(); 
        for(Autor autorPesquisa: autor){
            if (autorPesquisa.getId() == idAutor) {
                for(Livros livro : livros){
                    if(autorPesquisa.getNome().equalsIgnoreCase(livro.getAutor())){
                        System.out.println("\ntítulo: "+ livro.getTitulo());
                        System.out.println("autor: "+ livro.getAutor());
                    }
                }
            }
        }

    }
}

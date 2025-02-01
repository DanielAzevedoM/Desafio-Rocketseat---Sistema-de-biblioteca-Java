import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Autor;
import models.Emprestimo;
import models.Livros;

public class Menu {

    public void opcoes() {
        Scanner scanner = new Scanner(System.in);
        FuncoesBiblioteca biblioteca = new FuncoesBiblioteca();
        List<Livros> livros = new ArrayList<>();
        List<Emprestimo> emprestimos = new ArrayList<>();
        List<Autor> autor = new ArrayList<>();
        boolean sair = false;
        
        System.out.println("\nSistema inciado!");
        while (sair == false) {
            System.out.println("\nEscolha uma das opções abaixo: ");
            System.out.println("1-Adicionar livros");
            System.out.println("2-Adicionar Autor");
            System.out.println("3-Listar todos os livros disponíveis");
            System.out.println("4-Realizar empréstimo de um livro");
            System.out.println("5-Listar empréstimos");
            System.out.println("6-Devolver livro");
            System.out.println("7-Pesquisar livros de autores cadastrados");
            System.out.println("8-Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println(opcao);
            switch (opcao) {
                case 1:
                    biblioteca.adicionarLivro(livros);
                    break;
                case 2:
                    biblioteca.adicionarAutor(autor);
                    break;
                case 3:
                    biblioteca.listarLivrosDisponiveis(livros);
                    break;
                case 4:
                    biblioteca.emprestarLivro(livros, emprestimos);
                    break;
                case 5:
                    biblioteca.listarLivrosEmprestados(emprestimos);
                    break;
                case 6:
                    biblioteca.devolverLivro(livros, emprestimos);
                    break;
                case 7:
                    biblioteca.pesquisarLivrosDeAutores(autor, livros);
                    break;
                case 8:
                    sair = true;
                    break;
            }
        }
        scanner.close();
    }

}

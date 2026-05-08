package br.com.joaomonteiro.bibliotecamm;

import br.com.joaomonteiro.bibliotecamm.model.*;
import br.com.joaomonteiro.bibliotecamm.repository.DataBase;
import br.com.joaomonteiro.bibliotecamm.service.*;
import br.com.joaomonteiro.bibliotecamm.exception.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Cadastrar DVD");
            System.out.println("4 - Cadastrar revista");
            System.out.println("5 - Listar usuários");
            System.out.println("6 - Listar itens");
            System.out.println("7 - Emprestar");
            System.out.println("8 - Devolver");
            System.out.println("9 - Ver empréstimos");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){

                case 1:

                    System.out.println("Informe o nome do usuário: ");
                    String nome = sc.nextLine();

                    DataBase.adicionarUsuario(new Usuario(nome));

                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.println("Informe o título do livro: ");
                    String tituloLivro = sc.nextLine();

                    System.out.println("Informe o autor: ");
                    String autor = sc.nextLine();

                    System.out.println("Informe a quantidade disponível: ");
                    int qtdLivro = sc.nextInt();

                    DataBase.adicionarItemBiblioteca(
                            new Livro(tituloLivro, qtdLivro, autor)
                    );

                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 3:

                    System.out.println("Informe o título do DVD: ");
                    String tituloDVD = sc.nextLine();

                    System.out.println("Informe a duração em minutos: ");
                    int duracao = sc.nextInt();

                    System.out.println("Informe a quantidade disponível: ");
                    int qtdDVD = sc.nextInt();

                    DataBase.adicionarItemBiblioteca(
                            new DVD(tituloDVD, qtdDVD, duracao)
                    );

                    System.out.println("DVD cadastrado com sucesso!");
                    break;

                case 4:

                    System.out.println("Informe o título da revista: ");
                    String tituloRevista = sc.nextLine();

                    System.out.println("Informe o número da edição: ");
                    int edicao = sc.nextInt();

                    System.out.println("Informe a quantidade disponível: ");
                    int qtdRevista = sc.nextInt();

                    DataBase.adicionarItemBiblioteca(
                            new Revista(tituloRevista, qtdRevista, edicao)
                    );

                    System.out.println("Revista cadastrada com sucesso!");
                    break;

                case 5:

                    DataBase.listarUsuarios();
                    break;

                case 6:

                    DataBase.listarItens();
                    break;

                case 7:

                    try {

                        System.out.println("Informe o ID do usuário: ");
                        int idUsuario = sc.nextInt();

                        System.out.println("Informe o ID do item: ");
                        int idItem = sc.nextInt();

                        EmprestimoService.emprestar(
                                DataBase.buscarUsuarioID(idUsuario),
                                DataBase.buscarItemID(idItem)
                        );

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 8:

                    try {

                        DataBase.listarEmprestimos();

                        System.out.println("Informe o ID do empréstimo: ");
                        int idDevolucao = sc.nextInt();

                        EmprestimoService.devolver(idDevolucao);

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 9:

                    DataBase.listarEmprestimos();
                    break;

                case 0:

                    System.out.println("Encerrando...");
                    break;

                default:

                    System.out.println("Opção inválida");
            }
        }while(opcao != 0);

        sc.close();
    }
}

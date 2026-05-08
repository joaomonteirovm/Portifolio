package br.com.joaomonteiro.bibliotecamm.repository;

import br.com.joaomonteiro.bibliotecamm.model.*;

import java.util.LinkedList;
import java.util.List;

public class DataBase {

    public static List<Usuario> usuarios = new LinkedList<>();
    public static List<ItemBiblioteca> itens = new LinkedList<>();
    public static List<Emprestimo> emprestimos = new LinkedList<>();

    // USUÁRIOS

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void listarUsuarios() {

        System.out.println("\nLista de usuários");

        for (Usuario u : usuarios) {

            System.out.println("______________________");
            System.out.println(u);
        }
    }

    public static Usuario buscarUsuarioID(int id) {

        for (Usuario u : usuarios) {

            if (u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    // ITENS

    public static void adicionarItemBiblioteca(ItemBiblioteca item) {
        itens.add(item);
    }

    public static void listarItens() {

        System.out.println("\nLista de itens");

        for (ItemBiblioteca i : itens) {

            System.out.println("______________________");
            System.out.println(i);
        }
    }

    public static ItemBiblioteca buscarItemID(int id) {

        for (ItemBiblioteca i : itens) {

            if (i.getId() == id) {
                return i;
            }
        }

        return null;
    }

    // EMPRÉSTIMOS

    public static void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public static Emprestimo buscarEmprestimoID(int id) {

        for (Emprestimo e : emprestimos) {

            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    public static void listarEmprestimos() {

        System.out.println("\nLista de empréstimos");

        for (Emprestimo e : emprestimos) {

            e.estaAtrasado();

            System.out.println(
                    "ID: " + e.getId() +
                            " | Usuário: " + e.getUsuario().getNome() +
                            " | Item: " + e.getItem().getTitulo() +
                            " | Status: " + e.getStatus().getDescricao()
            );
        }
    }
}
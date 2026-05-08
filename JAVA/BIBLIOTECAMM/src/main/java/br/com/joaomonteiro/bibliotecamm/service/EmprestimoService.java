package br.com.joaomonteiro.bibliotecamm.service;

import br.com.joaomonteiro.bibliotecamm.exception.*;
import br.com.joaomonteiro.bibliotecamm.model.*;
import br.com.joaomonteiro.bibliotecamm.repository.DataBase;

public class EmprestimoService {

    public static void emprestar(Usuario usuario, ItemBiblioteca item) {

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        if (item == null) {
            throw new IllegalArgumentException("Item não encontrado");
        }

        if (!usuario.podeEmprestar()) {
            throw new UsuarioBloqueadoException("Usuário bloqueado");
        }

        if (item.getQtdDisponivel() <= 0) {
            throw new ItemIndisponivelException("Item indisponível");
        }

        Emprestimo emprestimo = new Emprestimo(usuario, item);

        DataBase.adicionarEmprestimo(emprestimo);

        item.setQtdDisponivel(item.getQtdDisponivel() - 1);
    }

    public static void devolver(int id) {

        Emprestimo emprestimo = DataBase.buscarEmprestimoID(id);

        if (emprestimo == null) {
            throw new IllegalArgumentException("Empréstimo não encontrado");
        }

        if (!emprestimo.getStatus().podeDevolver()) {
            throw new IllegalStateException("Empréstimo já concluído");
        }

        Usuario usuario = emprestimo.getUsuario();
        ItemBiblioteca item = emprestimo.getItem();

        item.setQtdDisponivel(item.getQtdDisponivel() + 1);

        if (emprestimo.calcularMulta() > 0) {

            usuario.setBloqueado(true);

            System.out.println("Usuário bloqueado");
            System.out.println("Multa: " + emprestimo.calcularMulta());
        }

        emprestimo.concluir();

        System.out.println("Item devolvido com sucesso!");
    }
}
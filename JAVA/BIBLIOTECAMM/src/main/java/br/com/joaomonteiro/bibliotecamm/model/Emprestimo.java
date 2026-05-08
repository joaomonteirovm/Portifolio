package br.com.joaomonteiro.bibliotecamm.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

    private static int proximoId = 1;

    private int id;

    private Usuario usuario;
    private ItemBiblioteca item;

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;

    private StatusEmprestimo status;

    public Emprestimo(Usuario usuario, ItemBiblioteca item) {

        this.id = proximoId++;

        this.usuario = usuario;
        this.item = item;

        this.dataEmprestimo = LocalDate.now();
        this.dataPrevista = dataEmprestimo.plusDays(7);

        this.status = StatusEmprestimo.EM_ANDAMENTO;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ItemBiblioteca getItem() {
        return item;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void concluir() {
        this.status = StatusEmprestimo.CONCLUIDO;
    }

    public boolean estaAtrasado() {

        if (status.isFinalizado()) {
            return false;
        }

        boolean atrasado = LocalDate.now().isAfter(dataPrevista);

        if (atrasado) {
            status = StatusEmprestimo.ATRASADO;
        }

        return atrasado;
    }

    public double calcularMulta() {

        if (!estaAtrasado()) {
            return 0;
        }

        return ChronoUnit.DAYS.between(dataPrevista, LocalDate.now());
    }
}
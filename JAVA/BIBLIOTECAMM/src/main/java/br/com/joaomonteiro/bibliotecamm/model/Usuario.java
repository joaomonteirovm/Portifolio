package br.com.joaomonteiro.bibliotecamm.model;

public class Usuario {

    private static int proximoId = 1;

    private int id;
    private String nome;
    private boolean bloqueado;

    public Usuario(String nome) {
        this.id = proximoId++;
        this.nome = nome;
        this.bloqueado = false;
    }

    public boolean podeEmprestar() {
        return !bloqueado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nBloqueado: " + (bloqueado ? "Sim" : "Não");
    }
}
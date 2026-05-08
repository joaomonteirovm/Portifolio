package br.com.joaomonteiro.bibliotecamm.model;

public class ItemBiblioteca {

    private static int proximoId = 1;

    private int id;
    private String titulo;
    private int qtdDisponivel;

    public ItemBiblioteca(String titulo, int qtdDisponivel) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.qtdDisponivel = qtdDisponivel;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nTítulo: " + titulo +
                "\nQuantidade disponível: " + qtdDisponivel;
    }
}
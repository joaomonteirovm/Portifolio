package br.com.joaomonteiro.bibliotecamm.model;

public class Revista extends ItemBiblioteca {

    private int edicao;

    public Revista(String titulo, int qtdDisponivel, int edicao) {
        super(titulo, qtdDisponivel);
        this.edicao = edicao;
    }


    @Override
    public String toString() {

        return getClass().getSimpleName() +
                "\nID: " + getId() +
                "\nTítulo: " + getTitulo() +
                "\nEdição: " + edicao +
                "\nQuantidade disponível: " + getQtdDisponivel();
    }
}
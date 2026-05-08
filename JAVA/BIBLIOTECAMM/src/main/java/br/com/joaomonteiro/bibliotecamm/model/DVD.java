package br.com.joaomonteiro.bibliotecamm.model;

public class DVD extends ItemBiblioteca {

    private int duracao;

    public DVD(String titulo, int qtdDisponivel, int duracao) {
        super(titulo, qtdDisponivel);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {

        return getClass().getSimpleName() +
                "\nID: " + getId() +
                "\nTítulo: " + getTitulo() +
                "\nDuração: " + duracao + " min" +
                "\nQuantidade disponível: " + getQtdDisponivel();
    }
}
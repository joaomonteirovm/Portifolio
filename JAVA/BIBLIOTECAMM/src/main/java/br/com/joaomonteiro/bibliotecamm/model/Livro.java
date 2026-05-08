package br.com.joaomonteiro.bibliotecamm.model;

public class Livro extends ItemBiblioteca {

    private String autor;

    public Livro(String titulo, int qtdDisponivel, String autor) {
        super(titulo, qtdDisponivel);
        this.autor = autor;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "\nID: " + getId() +
                "\nTítulo: " + getTitulo() +
                "\nAutor: " + autor +
                "\nQuantidade disponível: " + getQtdDisponivel();
    }
}
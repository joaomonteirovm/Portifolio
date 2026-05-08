package br.com.joaomonteiro.bibliotecamm.model;

public enum StatusEmprestimo {

    EM_ANDAMENTO("Em andamento", false) {
        @Override
        public boolean podeDevolver() {
            return true;
        }
    },

    ATRASADO("Atrasado", false) {
        @Override
        public boolean podeDevolver() {
            return true;
        }
    },

    CONCLUIDO("Concluído", true) {
        @Override
        public boolean podeDevolver() {
            return false;
        }
    };

    private String descricao;
    private boolean finalizado;

    StatusEmprestimo(String descricao, boolean finalizado) {
        this.descricao = descricao;
        this.finalizado = finalizado;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public abstract boolean podeDevolver();
}
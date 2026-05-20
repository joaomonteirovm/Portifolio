import sqlite3


def criar_banco():

    conexao = sqlite3.connect("dados.db")

    cursor = conexao.cursor()

    cursor.execute("""
    CREATE TABLE IF NOT EXISTS vendas (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        produto TEXT,
        categoria TEXT,
        preco REAL,
        quantidade INTEGER,
        data TEXT,
        faturamento REAL
    )
    """)

    conexao.commit()

    conexao.close()

    print("Banco criado com sucesso!")


if __name__ == "__main__":
    criar_banco()
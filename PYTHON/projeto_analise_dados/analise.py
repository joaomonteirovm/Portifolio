import sqlite3
import pandas as pd
import matplotlib.pyplot as plt


def executar_analise():

    conexao = sqlite3.connect("dados.db")

    df = pd.read_sql_query(
        "SELECT * FROM vendas",
        conexao
    )

    print("\n=== DADOS ===")
    print(df)

    total = df["faturamento"].sum()

    print("\n=== FATURAMENTO TOTAL ===")
    print(total)

    resultado = df.groupby(
        "data"
    )["faturamento"].sum()

    print("\n=== FATURAMENTO POR DATA ===")
    print(resultado)

    categoria = df.groupby(
        "categoria"
    )["faturamento"].sum()

    print("\n=== FATURAMENTO POR CATEGORIA ===")
    print(categoria)

    categoria.plot(kind="bar")

    plt.title("Faturamento por Categoria")

    plt.xlabel("Categoria")

    plt.ylabel("Faturamento")

    plt.show()

    conexao.close()


if __name__ == "__main__":

    executar_analise()
import sqlite3
import pandas as pd


def extrair_dados():

    df = pd.read_csv("vendas.csv")

    print(df)

    return df


def transformar_dados(df):

    df["faturamento"] = (
        df["preco"] * df["quantidade"]
    )

    return df


def carregar_dados(df):

    conexao = sqlite3.connect("dados.db")

    df.to_sql(
        "vendas",
        conexao,
        if_exists="replace",
        index=False
    )

    conexao.close()

    print("Dados carregados!")


def executar_etl():

    df = extrair_dados()

    df = transformar_dados(df)

    carregar_dados(df)


if __name__ == "__main__":
    executar_etl()
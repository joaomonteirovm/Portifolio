from banco import criar_banco
from etl import executar_etl
from analise import executar_analise


def menu():

    while True:

        print("\n========== MENU ==========")

        print("1 - Criar banco")

        print("2 - Executar ETL")

        print("3 - Executar análise")

        print("4 - Sair")

        opcao = input("\nEscolha uma opção: ")

        if opcao == "1":

            criar_banco()

        elif opcao == "2":

            executar_etl()

        elif opcao == "3":

            executar_analise()

        elif opcao == "4":

            print("\nEncerrando sistema...")

            break

        else:

            print("\nOpção inválida!")


if __name__ == "__main__":

    menu()
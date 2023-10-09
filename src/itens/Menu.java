package itens;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	Scanner key = new Scanner(System.in);
	Supermercado comandos = new Supermercado();
	double valor;
	String nome;
	String tipo;
	int quantidade;

	public void opcoesMenu() {
		System.out.println("Menu\n" + "1)Listar produtos\r\n" + "2)Busca de produtos (nome)\r\n"
				+ "3)Busca de produtos (tipo)\r\n" + "4)Cadastrar produtos\r\n" + "5)Excluir produto\r\n"
				+ "6)Alterar valor de produto\r\n" + "7)Alterar estoque de produto\r\n" + "0) Encerrar");
	}

	public void selecaoMenu() {
		int opcMenu;	
		do {
			opcoesMenu();
			try {
				opcMenu = key.nextInt();
			} catch (InputMismatchException e) {
				opcMenu = -1;
				key.next();
			}
			
			switch (opcMenu) {
			case 1:
				comandos.listarProdutos();
				break;
			case 2:
				System.out.println("Qual o Produto que deseja:");
				comandos.buscarPorNome(key.next());
				break;
			case 3:
				System.out.println("Qual o tipo de produto que deseja:");
				comandos.buscarPorTipo(key.next());
				break;
			case 4:
				System.out.println("Cadastro de produto:");
				System.out.println("Qual o produto:");
				nome = key.next();
				System.out.println("Qual tipo:");
				tipo = key.next();
				System.out.println("Qual o valor: ");
				do {
				    try {
				        valor = key.nextDouble();
				        if (valor < 0) {
				            System.out.println("O valor não pode ser negativo. Tente novamente: ");
				        }
				    } catch (InputMismatchException e) {
				        System.out.println("Valor inválido. Deve ser um número separado por vírgula para centavos. Tente novamente: ");
				        key.nextLine();
				        valor = -1;
				    }
				} while (valor < 0);
				System.out.println("Qual a quantidade");
				do {
				    try {
				        quantidade = key.nextInt();
				        if (quantidade <= 0) {
				            System.out.println("O valor não pode ser negativo. Tente novamente: ");
				        }
				    } catch (InputMismatchException e) {
				        System.out.println("Valor inválido. Deve ser um número separado por vírgula para centavos. Tente novamente: ");
				        key.nextLine();
				        quantidade = -1;
				    }
				} while (quantidade <= 0);
				comandos.cadastrarProduto(nome, tipo, valor, quantidade);
				break;

			case 5:
				System.out.println("Qual produto ira excluir:");
				String excluir = key.next();
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir esse item?", "Confirmação", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					comandos.excluirProduto(excluir);
					System.out.println("Produto excluido com sucesso");
				}else {
					System.out.println("Operação cancelada");
				}
				break;
			
			case 6:
				System.out.println("qual o produto que ira trocar o valor");
				nome = key.next();
				System.out.println("Qual o novo valor:");
				do {
				    try {
				        valor = key.nextDouble();
				        if (valor < 0) {
				            System.out.println("O valor não pode ser negativo. Tente novamente: ");
				        }
				    } catch (InputMismatchException e) {
				        System.out.println("Valor inválido. Deve ser um número separado por vírgula para centavos. Tente novamente: ");
				        key.nextLine();
				        valor = -1;
				    }
				} while (valor < 0);
				
				comandos.alterarValor(nome, valor);
				break;
			case 7:
				System.out.println("qual o produto que ira mudar  quantidade no estoque");
				nome = key.next();
				System.out.println("quantos tem no estoque");
				do {
				    try {
				        quantidade = key.nextInt();
				        if (quantidade <= 0) {
				            System.out.println("O valor não pode ser negativo. Tente novamente: ");
				        }
				    } catch (InputMismatchException e) {
				        System.out.println("Valor inválido. Deve ser um número separado por vírgula para centavos. Tente novamente: ");
				        key.nextLine();
				        quantidade = -1;
				    }
				} while (quantidade <= 0);
				comandos.alterarEstoque(nome, quantidade);
				break;
			case 0:
				break;
			default:
				System.out.println("Comando ivalido");
				break;
			}
			valor = -1;
			quantidade = -1;
		} while (opcMenu != 0);
	}
}

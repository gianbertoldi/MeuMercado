package itens;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Produto> listaDeProdutos;

	public Supermercado() {
		listaDeProdutos = new ArrayList<>();
		// Adicione produtos iniciais
		/*adicionarProduto("Itaipava", "Cerveja", 1.50, 200);
		adicionarProduto("Skol", "Cerveja", 1.70, 300);
		adicionarProduto("Del Valle", "Suco", 2.10, 100);
		adicionarProduto("Pepsi Cola 2L", "Refrigerante", 3.00, 800);
		adicionarProduto("Guaraná Charrua 2L", "Refrigerante", 2.50, 340);
		adicionarProduto("Bis branco", "Chocolate", 2.70, 50);*/
	}

	public void listarProdutos() {
		if (listaDeProdutos.isEmpty()) {
			System.out.println("A lista de produtos está vazia.");
		} else {
			for (Produto produto : listaDeProdutos) {
				System.out.println(produto);
			}
		}
	}

	public void buscarPorNome(String nome) {
		String nomeSemAcentoInput = removerAcentos(nome).toLowerCase();
		boolean encontrou = false;
		for (Produto produto : listaDeProdutos) {
			String nomeSemAcentoProduto = removerAcentos(produto.getNome()).toLowerCase();
			if (nomeSemAcentoProduto.contains(nomeSemAcentoInput)) {
				System.out.println(produto);
				encontrou = true;
			}
		}
		if (!encontrou) {
			System.out.println("Nenhum produto encontrado com o nome '" + nome + "'.");
		}
	}

	public void buscarPorTipo(String tipo) {
		String tipoSemAcentoInput = removerAcentos(tipo).toLowerCase();
		boolean encontrou = false;
		for (Produto produto : listaDeProdutos) {
			String tipoSemAcentoProduto = removerAcentos(produto.getTipo()).toLowerCase();
			if (tipoSemAcentoProduto.contains(tipoSemAcentoInput)) {
				System.out.println(produto);
				encontrou = true;
			}
		}
		if (!encontrou) {
			System.out.println("Nenhum produto encontrado com o nome '" + tipo + "'.");
		}
	}

	public void cadastrarProduto(String nome, String tipo, double valor, int quantidadeEmEstoque) {
		adicionarProduto(nome, tipo, valor, quantidadeEmEstoque);
	}

	public void excluirProduto(String nome) {
		String nomeSemAcentoInput = removerAcentos(nome).toLowerCase();

		listaDeProdutos.removeIf(produto -> {
			String nomeSemAcentoProduto = removerAcentos(produto.getNome()).toLowerCase();
			return nomeSemAcentoProduto.contains(nomeSemAcentoInput);
		});
	}

	public void alterarValor(String nome, double novoValor) {
		for (Produto produto : listaDeProdutos) {
			String nomeSemAcentoProduto = removerAcentos(produto.getNome()).toLowerCase();
			String nomeSemAcentoInput = removerAcentos(nome).toLowerCase();

			if (nomeSemAcentoProduto.contains(nomeSemAcentoInput)) {
				produto.setValor(novoValor);
				break;
			}
		}
	}

	public void alterarEstoque(String nome, int novoValor) {
		for (Produto produto : listaDeProdutos) {
			String nomeSemAcentoProduto = removerAcentos(produto.getNome()).toLowerCase();
			String nomeSemAcentoInput = removerAcentos(nome).toLowerCase();

			if (nomeSemAcentoProduto.contains(nomeSemAcentoInput)) {
				produto.setQuantidadeEmEstoque(novoValor);
				break;
			}
		}
	}

	private void adicionarProduto(String nome, String tipo, double valor, int quantidadeEmEstoque) {
		int codigo = listaDeProdutos.size();
		Produto produto = new Produto(codigo, nome, tipo, valor, quantidadeEmEstoque);
		listaDeProdutos.add(produto);
	}

	private String removerAcentos(String texto) {
		if (texto == null) {
			return null;
		}
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

		return texto;
	}
}

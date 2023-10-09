package itens;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Produto> listaDeProdutos;

    public Supermercado() {
        listaDeProdutos = new ArrayList<>();
        // Adicione produtos iniciais
        adicionarProduto("Itaipava", "Cerveja", 1.50, 200);
        adicionarProduto("Skol", "Cerveja", 1.70, 300);
        adicionarProduto("Del Valle", "Suco", 2.10, 100);
        adicionarProduto("Pepsi Cola 2L", "Refrigerante", 3.00, 800);
        adicionarProduto("Guaraná Charrua 2L", "Refrigerante", 2.50, 340);
        adicionarProduto("Bis branco", "Chocolate", 2.70, 50);
    }
    
    private void adicionarProduto(String nome, String tipo, double valor, int quantidadeEmEstoque) {
        int codigo = listaDeProdutos.size(); // Gere o código automaticamente com base na posição na lista
        Produto produto = new Produto(codigo, nome, tipo, valor, quantidadeEmEstoque);
        listaDeProdutos.add(produto);
    }

    // F001: Listar produtos
    public void listarProdutos() {
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto);
        }
    }

    // F002: Busca de produtos (nome)
    public void buscarPorNome(String nome) {
        boolean encontrou = false;

        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println(produto);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto encontrado com o nome '" + nome + "'.");
        }
    }

    // F003: Busca de produtos (tipo)
    public void buscarPorTipo(String tipo) {
    	boolean encontrou = false;

        for (Produto produto : listaDeProdutos) {
            if (produto.getTipo().toLowerCase().contains(tipo.toLowerCase())) {
                System.out.println(produto);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto encontrado com o nome '" + tipo + "'.");
        }
    }

    // F004: Cadastrar produtos
    public void cadastrarProduto(String nome, String tipo, double valor, int quantidadeEmEstoque) {
    	adicionarProduto(nome,tipo,valor,quantidadeEmEstoque);
    }

    // F005: Excluir produto
    public void excluirProduto(String nome) {
        listaDeProdutos.removeIf(produto ->  produto.getNome().toLowerCase().contains(nome.toLowerCase()));
    }

    // F006: Alterar valor de produto
    public void alterarValor(String nome, double novoValor) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                produto.setValor(novoValor);
                break;
            }
        }
    }
        
     // F006: Alterar valor de produto
        public void alterarEstoque(String nome, int novoValor) {
            for (Produto produto : listaDeProdutos) {
                if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    produto.setQuantidadeEmEstoque(novoValor);
                    break;
                }
            }
    }
}
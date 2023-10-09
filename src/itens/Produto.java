package itens;

class Produto {
	private int codigo;
	private String nome;
	private String tipo;
	private double valor;
	private int quantidadeEmEstoque;

	public Produto(int codigo, String nome, String tipo, double valor, int quantidadeEmEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	// Getters e setters para os atributos

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor
				+ ", Quantidade em Estoque: " + quantidadeEmEstoque;
	}
}
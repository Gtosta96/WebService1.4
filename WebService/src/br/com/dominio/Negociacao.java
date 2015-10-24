package br.com.dominio;

import java.io.Serializable;

public class Negociacao implements Serializable { /*TESTAR SE SERIALIZABLE FUNCIONA EM JAVA 4*/

	private static final long serialVersionUID = 1L;
	private int id;
	private String preco;
	private String quantidade;
	
	public Negociacao() {};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

//	public String toString() {
//		return "Negociacao [id=" + id + ", preco=" + preco + ", quantidade="
//				+ quantidade + "]";
//	}
}
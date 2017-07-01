package model;

public class Mercadoria {
	int id;
	String fornecedor;
	Armazem localizacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Armazem getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Armazem localizacao) {
		this.localizacao = localizacao;
	}

	
	
}

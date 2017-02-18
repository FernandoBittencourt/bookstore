package br.com.fbscript.bookstore.model.enumerate;

public enum TipoDoProduto {
	EBOOK("eBook"), IMPRESSO("Impresso"), COMBO("Combo");
	
	private String titulo;

	private TipoDoProduto(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
}

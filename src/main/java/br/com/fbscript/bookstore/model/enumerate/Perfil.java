package br.com.fbscript.bookstore.model.enumerate;

public enum Perfil {
	PADRAO("Padrão"), ADMIN("Administrador");

	private String titulo;

	private Perfil(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
}

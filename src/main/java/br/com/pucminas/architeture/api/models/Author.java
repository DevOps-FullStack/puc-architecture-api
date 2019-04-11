package br.com.pucminas.architeture.api.models;

public class Author extends ModelBase {
	private String name;

	public Author(int id, String name) {
		super(id);
		this.name = name;
	}

	public Author() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

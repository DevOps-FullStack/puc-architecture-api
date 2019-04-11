package br.com.pucminas.architeture.api.models;

public class Review extends ModelBase {
	private String descrition;
	private int idBook;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int id, String descrition, int idBook) {
		super(id);
		this.descrition = descrition;
		this.idBook = idBook;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

}

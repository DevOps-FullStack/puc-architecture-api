package br.com.pucminas.architeture.api.models;

public class Order extends ModelBase {
	private String street;
	private int number;
	private String neighborhood;
	private String state;
	private Status status;

	public Order(int id, String street, int number, String neighborhood, String state, Status status) {
		super(id);
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.state = state;
		this.status = status;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

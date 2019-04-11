package br.com.pucminas.architeture.api.models;

public enum Status {
	DELIVERED("Delivered"),
	WAITING("Waiting");
	
	private String status;
	
	Status(String status){
	this.status = status;	
	}
	
	@Override
	public String toString() {	
		return this.status;
	}
}

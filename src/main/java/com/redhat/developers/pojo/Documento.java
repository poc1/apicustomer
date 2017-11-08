package com.redhat.developers.pojo;

public class Documento extends Peticion 
{
	String document_number;

	/**
	 * Numero de documento ( codigo de cliente, curp, rfc, etc )
	 * @return
	 */
	public String getDocument_number() {
		return document_number;
	}

	/**
	 * Numero de documento ( codigo de cliente, curp, rfc, etc )
	 * @param document_number
	 */
	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}
	
	

}


package com.redhat.developers.pojo;

public class Peticion {

	//private String accept;
	//private String accept_language;
	//private String content_type;
	private String x_ibm_client_id;
	private String authorization;
	private String x_santander_global_id;
	
	
	
//	public String getAccept() {
//		return accept;
//	}
//	public void setAccept(String accept) {
//		this.accept = accept;
//	}
//	public String getAccept_language() {
//		return accept_language;
//	}
//	public void setAccept_language(String accept_language) {
//		this.accept_language = accept_language;
//	}
//	public String getContent_type() {
//		return content_type;
//	}
//	public void setContent_type(String content_type) {
//		this.content_type = content_type;
//	}
	public String getX_ibm_client_id() {
		return x_ibm_client_id;
	}
	public void setX_ibm_client_id(String x_ibm_client_id) {
		this.x_ibm_client_id = x_ibm_client_id;
	}
	/**
	 * Access Token
	 * @return
	 */
	public String getAuthorization() {
		return authorization;
	}
	/**
	 * Access Token
	 * @param authorization
	 */
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getX_santander_global_id() {
		return x_santander_global_id;
	}
	public void setX_santander_global_id(String x_santander_global_id) {
		this.x_santander_global_id = x_santander_global_id;
	}
	
	
	
	
}

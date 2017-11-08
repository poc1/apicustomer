package com.redhat.developers.msa.ola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;
import com.redhat.developers.pojo.Account;
import com.redhat.developers.pojo.Company;
import com.redhat.developers.pojo.Documento;
import com.redhat.developers.pojo.Persona;


@Service
public class CustomerService {

	public CustomerService() {}
	

	/**
	 * Busqueda por documentos o codigo de cliente 
	 * @param documento
	 * @return
	 */
	public String getCustomerByDocument(Documento documento)
	{
		
	  //String urlString = "http://localhost:8081/customer/document?";
	    String urlString = "http://apibank2-poc1.193b.starter-ca-central-1.openshiftapps.com:80/customer/document?";
      //String urlString = "https://webapigateway.dev.mx.corp/santander-mexico/intranet-client-dev/customers?";
		
		urlString = urlString + "document_number="+documento.getDocument_number();
		
		StringBuffer response = new StringBuffer();
		
		try {
				  
		  URL url = new URL(urlString);
		  HttpURLConnection con = (HttpURLConnection) url.openConnection();
		 
		  // By default it is GET request
		  con.setRequestMethod("GET");
		 
		  //add request header
		  con.setRequestProperty("Accept", "application/json");
		  con.setRequestProperty("Accept-Language", "es-ES");
		  con.setRequestProperty("Content-Type", "application/json");
		  con.setRequestProperty("x-ibm-client-id", documento.getX_ibm_client_id());
		  con.setRequestProperty("Authorization", documento.getAuthorization());
		  con.setRequestProperty("x-santander-global-id", documento.getX_santander_global_id());
		 
		  //int responseCode = con.getResponseCode();
			 
		  // Reading response from input Stream
		  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		  String output;
		  		 
		  while ((output = in.readLine()) != null) {
		   response.append(output);
		  }
		  in.close();
		  
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	  return response.toString();		
	}
	
	
	
	
	
	/**
	 * CONSULTA DE CustomerData por el nombre, apellido paterno y/o materno
	 * @param persona
	 * @return
	 */
	public String getCustomerByName(Persona persona)
	{
		//String urlString = "http://localhost:8081/customer/name?";
		  String urlString = "http://apibank2-poc1.193b.starter-ca-central-1.openshiftapps.com:80/customer/name?";
		//String urlString = "https://webapigateway.dev.mx.corp/santander-mexico/intranet-client-dev/customers?";
		
		urlString = urlString + (persona.getName().equals("")?"":"name="+persona.getName() + "&");
		urlString = urlString + (persona.getPaternal_name().equals("")?"":"paternal_name="+persona.getPaternal_name() + "&");
		urlString = urlString + (persona.getMaternal_name().equals("")?"":"maternal_name="+persona.getMaternal_name() + "&");
		
		if(urlString.endsWith("&"))
			urlString = urlString.substring(0, urlString.length()-1);
		  
			
			StringBuffer response = new StringBuffer();
			
			try {
					  
			  URL url = new URL(urlString);
			  HttpURLConnection con = (HttpURLConnection) url.openConnection();
			 
			  // By default it is GET request
			  con.setRequestMethod("GET");
			 
			  //add request header
			  con.setRequestProperty("Accept", "application/json");
			  con.setRequestProperty("Accept-Language", "es-ES");
			  con.setRequestProperty("Content-Type", "application/json");
			  con.setRequestProperty("x-ibm-client-id", persona.getX_ibm_client_id());
			  con.setRequestProperty("Authorization", persona.getAuthorization());
			  con.setRequestProperty("x-santander-global-id", persona.getX_santander_global_id());
			 
			  //int responseCode = con.getResponseCode();
				 
			  // Reading response from input Stream
			  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			  String output;
			  		 
			  while ((output = in.readLine()) != null) {
			   response.append(output);
			  }
			  in.close();
			  
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
			
		  return response.toString();		
	}
		
	
	/**
	 * Busqueda por nombre de empresa
	 * @param company
	 * @return
	 */
	public String getCustomerByCompany(Company company)
	{
		//String urlString = "http://localhost:8081/customer/company?";
		  String urlString = "http://apibank2-poc1.193b.starter-ca-central-1.openshiftapps.com:80/customer/company?";
		//String urlString = "https://webapigateway.dev.mx.corp/santander-mexico/intranet-client-dev/customers?";
		
		urlString = urlString + "company_name="+company.getCompany_name();
					  
			
			StringBuffer response = new StringBuffer();
			
			try {
					  
			  URL url = new URL(urlString);
			  HttpURLConnection con = (HttpURLConnection) url.openConnection();
			 
			  // By default it is GET request
			  con.setRequestMethod("GET");
			 
			  //add request header
			  con.setRequestProperty("Accept", "application/json");
			  con.setRequestProperty("Accept-Language", "es-ES");
			  con.setRequestProperty("Content-Type", "application/json");
			  con.setRequestProperty("x-ibm-client-id", company.getX_ibm_client_id());
			  con.setRequestProperty("Authorization", company.getAuthorization());
			  con.setRequestProperty("x-santander-global-id", company.getX_santander_global_id());
			 
			  //int responseCode = con.getResponseCode();
				 
			  // Reading response from input Stream
			  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			  String output;
			  		 
			  while ((output = in.readLine()) != null) {
			   response.append(output);
			  }
			  in.close();
			  
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
			
		  return response.toString();
	}
		
	
	/**
	 * Busqueda por número de cuenta
	 * @param accountNumber
	 * @return
	 */
	public String getCustomerByAccountNumber(Account account)
	{
		//String urlString = "http://localhost:8081/customer/accountnum?";
		  String urlString = "http://apibank2-poc1.193b.starter-ca-central-1.openshiftapps.com:80/customer/accountnum?";
		//String urlString = "https://webapigateway.dev.mx.corp/santander-mexico/intranet-client-dev/customers?";
		
		urlString = urlString + "account_number="+ account.getAccount_number();
					  
			
			StringBuffer response = new StringBuffer();
			
			try {
					  
			  URL url = new URL(urlString);
			  HttpURLConnection con = (HttpURLConnection) url.openConnection();
			 
			  // By default it is GET request
			  con.setRequestMethod("GET");
			 
			  //add request header
			  con.setRequestProperty("Accept", "application/json");
			  con.setRequestProperty("Accept-Language", "es-ES");
			  con.setRequestProperty("Content-Type", "application/json");
			  con.setRequestProperty("x-ibm-client-id", account.getX_ibm_client_id());
			  con.setRequestProperty("Authorization", account.getAuthorization());
			  con.setRequestProperty("x-santander-global-id", account.getX_santander_global_id());
			 
			  //int responseCode = con.getResponseCode();
				 
			  // Reading response from input Stream
			  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			  String output;
			  		 
			  while ((output = in.readLine()) != null) {
			   response.append(output);
			  }
			  in.close();
			  
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
			
		  return response.toString();		
	}
	
}

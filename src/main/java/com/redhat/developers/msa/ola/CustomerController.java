/**
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.developers.msa.ola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.developers.model.CustomerData;
import com.redhat.developers.model.CustomerDocumentDetail;
import com.redhat.developers.pojo.Account;
import com.redhat.developers.pojo.Company;
import com.redhat.developers.pojo.Documento;
import com.redhat.developers.pojo.Persona;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CustomerController {

public final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
			this.customerService = customerService;
	}

	
	
	/**
	 * Búsqueda por codigo de cliente y/o por Documentos
	 * @param document_number
	 * @return
	 */
	@RequestMapping(value="/document/", method=RequestMethod.POST)
	@ApiOperation(value = "Documentos o Codigo del Cliente (RFC, CURP, PASAPORTE, CODIGO DE CLIENTE)", response = CustomerDocumentDetail.class, produces = "application/json")
	public /*Iterable<CustomerDocumentDetail>*/ @ResponseBody String getCustomerByDocument(@RequestBody Documento documento)
	{
		return customerService.getCustomerByDocument(documento);
	}
	
	
	/**
	 * Busqueda por nombre, apellido paterno, materno, etc 
	 * @param person
	 * @return
	 */
	@RequestMapping(value="/name/", method=RequestMethod.POST)
	@ApiOperation(value = "Nombre y Apellido Paterno o Nombre, Apellido Paterno y Materno o Apellido Paterno y Apellido Materno",response = CustomerData.class, produces = "application/json")
	public /*Iterable<CustomerData>*/ @ResponseBody String getCustomerByDocument(@RequestBody Persona persona)
	{
		return customerService.getCustomerByName(persona);
	}	
	
	
	/**
	 * Busqueda por nombre de empresa
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/company/", method=RequestMethod.POST)
	@ApiOperation(value = "Nombre de la Empresa",response = CustomerData.class, produces = "application/json")
	public /*Iterable<CustomerData>*/ @ResponseBody String getCustomerByCompany(@RequestBody Company company)
	{
		return customerService.getCustomerByCompany(company);
	}
	
	
	/**
	 * Búsqueda por número de cuenta
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/accountnum/", method=RequestMethod.POST)
	@ApiOperation(value = "Número de Cuenta", response = CustomerData.class, produces = "application/json")
	public /*Iterable<CustomerData>*/ @ResponseBody String getCustomerByAccountNumber(@RequestBody Account account)
	{
		return customerService.getCustomerByAccountNumber(account);
	}

}

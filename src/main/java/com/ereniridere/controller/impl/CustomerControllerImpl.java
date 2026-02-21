package com.ereniridere.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ereniridere.controller.ICustomerController;
import com.ereniridere.dto.DtoCustomer;
import com.ereniridere.services.impl.CustomerServiceImpl;

@RestController
@RequestMapping("rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
		return customerService.findCustomerById(id);
	}

}

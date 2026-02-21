package com.ereniridere.controller;

import com.ereniridere.dto.DtoCustomer;

public interface ICustomerController {

	public DtoCustomer findCustomerById(Long id);
}

package com.ereniridere.services;

import com.ereniridere.dto.DtoCustomer;

public interface ICustomerService {

	public DtoCustomer findCustomerById(Long id);
}

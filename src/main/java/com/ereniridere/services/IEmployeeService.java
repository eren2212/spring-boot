package com.ereniridere.services;

import java.util.List;

import com.ereniridere.dto.DtoEmployee;

public interface IEmployeeService {
	public List<DtoEmployee> findAllEmployee();
}

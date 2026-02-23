package com.ereniridere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ereniridere.controller.IEmployeeController;
import com.ereniridere.dto.DtoEmployee;
import com.ereniridere.services.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping(path = "/list")
	@Override
	public List<DtoEmployee> findAllEmployee() {
		return employeeService.findAllEmployee();

	}

}

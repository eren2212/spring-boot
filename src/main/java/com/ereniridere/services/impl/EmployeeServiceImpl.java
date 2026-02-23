package com.ereniridere.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ereniridere.dto.DtoDepartment;
import com.ereniridere.dto.DtoEmployee;
import com.ereniridere.entites.Employee;
import com.ereniridere.repository.EmployeeRepository;
import com.ereniridere.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<DtoEmployee> findAllEmployee() {
		List<DtoEmployee> employees = new ArrayList<>();

		List<Employee> dbEmployees = employeeRepository.findAll();

		if (dbEmployees != null && !dbEmployees.isEmpty()) {

			for (Employee employee : dbEmployees) {

				DtoEmployee dtoEmployee = new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);

				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(),
						employee.getDepartment().getDepartmentName()));

				employees.add(dtoEmployee);
			}
		}

		return employees;
	}

}

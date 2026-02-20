package com.ereniridere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ereniridere.controller.IStudentController;
import com.ereniridere.dto.DtoStudent;
import com.ereniridere.dto.DtoStudentIU;
import com.ereniridere.services.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")

public class StudentControllerImpl implements IStudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudent) {
		return studentService.saveStudent(dtoStudent);
	}

	@GetMapping(path = "/all")
	@Override
	public List<DtoStudent> getAllStudent() {
		return studentService.getAllStudents();
	}

	@GetMapping(path = "/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping(path = "/{id}")
	@Override
	public void deleteStudentById(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudentById(id);
	}

	@PutMapping(path = "/{id}")
	@Override
	public DtoStudent updateStudentById(@PathVariable(name = "id") Integer id,
			@RequestBody DtoStudentIU dtoUpdateStudent) {
		return studentService.updateStudentById(id, dtoUpdateStudent);
	}

}

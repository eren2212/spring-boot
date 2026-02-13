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
import com.ereniridere.entites.Student;
import com.ereniridere.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")

public class StudentControllerImpl implements IStudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping(path = "/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping(path = "/all")
	@Override
	public List<Student> getAllStudent() {
		return studentService.getAllStudents();
	}

	@GetMapping(path = "/{id}")
	@Override
	public Student getStudentById(@PathVariable(name = "id") Integer id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping(path = "/{id}")
	@Override
	public void deleteStudentById(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudentById(id);
	}

	@PutMapping(path = "/{id}")
	@Override
	public Student updateStudentById(@PathVariable(name = "id") Integer id, @RequestBody Student updateStudent) {
		return studentService.updateStudentById(id, updateStudent);
	}

}

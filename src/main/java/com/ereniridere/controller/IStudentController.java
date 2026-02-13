package com.ereniridere.controller;

import java.util.List;

import com.ereniridere.entites.Student;

public interface IStudentController {

	public Student saveStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(Integer id);

	public void deleteStudentById(Integer id);

	public Student updateStudentById(Integer id, Student updateStudent);
}

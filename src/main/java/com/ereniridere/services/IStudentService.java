package com.ereniridere.services;

import java.util.List;

import com.ereniridere.entites.Student;

public interface IStudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(Integer id);

	public void deleteStudentById(Integer id);

	public Student updateStudentById(Integer id, Student updateStudent);

}

package com.ereniridere.controller;

import java.util.List;

import com.ereniridere.dto.DtoStudent;
import com.ereniridere.dto.DtoStudentIU;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU dtoStudent);

	public List<DtoStudent> getAllStudent();

	public DtoStudent getStudentById(Integer id);

	public void deleteStudentById(Integer id);

	public DtoStudent updateStudentById(Integer id, DtoStudentIU dtoUpdateStudent);
}

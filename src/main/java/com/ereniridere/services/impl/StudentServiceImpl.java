package com.ereniridere.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ereniridere.dto.DtoStudent;
import com.ereniridere.dto.DtoStudentIU;
import com.ereniridere.entites.Student;
import com.ereniridere.repository.StudentRepository;
import com.ereniridere.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudent) {

		DtoStudent response = new DtoStudent();
		Student student = new Student();

		BeanUtils.copyProperties(dtoStudent, student);
		Student dbStudent = studentRepository.save(student);

		BeanUtils.copyProperties(dbStudent, response);

		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();

		List<Student> studentList = studentRepository.findAll();

		for (Student student : studentList) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoList.add(dtoStudent);
		}

		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent()) {
			Student student = optional.get();
			BeanUtils.copyProperties(student, dtoStudent);

			return dtoStudent;
		}
		return null;
	}

	@Override
	public void deleteStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
		}

	}

	@Override
	public DtoStudent updateStudentById(Integer id, DtoStudentIU dtoUpdateStudent) {
		Optional<Student> optional = studentRepository.findById(id);
		DtoStudent dtoStudent = new DtoStudent();

		
		if (optional.isPresent()) {
			Student dbStudent = optional.get();
			
			dbStudent.setFirstName(dtoUpdateStudent.getFirstName());
			dbStudent.setLastName(dtoUpdateStudent.getLastName());
			dbStudent.setBirthOfDate(dtoUpdateStudent.getBirthOfDate());
			
			Student updateedStudent = studentRepository.save(dbStudent);
			
			BeanUtils.copyProperties(updateedStudent,dtoStudent);
			return dtoStudent;
	
		}

		return null;
	}

}

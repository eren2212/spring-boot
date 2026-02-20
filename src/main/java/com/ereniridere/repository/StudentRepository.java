package com.ereniridere.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ereniridere.entites.Student;

//burada ilk parametre entite diğeri ID değişninin typeı

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// özel bir sorgu yazmak için kullanıcaz yani custom
	// iki adet sorgu tipi var
	// HQL:Bunda sınıfın ismi ve sınıfın değişkenlerini kullanıyoruz
	// SQL: burada tablo ismi ve colonlarını kullanıyoruz.

	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudentsAbi();

	@Query(value = "select * from student.student s WHERE s.id=:studentId", nativeQuery = true)
	Optional<Student> findByIDAbi(Integer studentId);

}

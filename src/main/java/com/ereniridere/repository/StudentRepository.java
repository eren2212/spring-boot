package com.ereniridere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ereniridere.entites.Student;

//burada ilk parametre entite diğeri ID değişninin typeı

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

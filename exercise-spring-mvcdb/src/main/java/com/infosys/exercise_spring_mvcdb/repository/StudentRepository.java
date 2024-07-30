package com.infosys.exercise_spring_mvcdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.exercise_spring_mvcdb.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE STUDENT SET MARKS = ? WHERE REGNO = ?", nativeQuery = true)
	public void updateStudent(Integer marks, Integer regno);
}

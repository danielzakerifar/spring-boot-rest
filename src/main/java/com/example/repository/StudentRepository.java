package com.example.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.entity.FirstProjection;
import com.example.entity.Student;

@RepositoryRestResource(path = "std", collectionResourceRel = "stds", excerptProjection = FirstProjection.class )
public interface StudentRepository extends JpaRepository<Student, Long> {

	@RestResource(path="email", exported = false)
	public Student findByEmail(String email);
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameAndLastName(String firstName,String lastName);
	
	public Page<Student> findByFirstNameOrLastName(String firstName,String lastName,Pageable pageable);
	
}

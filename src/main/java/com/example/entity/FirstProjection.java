package com.example.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Student.class, name = "firstProjection")
public interface FirstProjection {
	
	Long getId();
	
	String getEmail();
	
	@Value("#{target.firstName}" + " " + "#{target.lastName}")
	String getFullName();

	@Value("#{target.subjectLearning.size()}")
	int getTotalSubjects();
}

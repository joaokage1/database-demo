package com.database.databasedemo;

import com.database.databasedemo.entity.Course;
import com.database.databasedemo.repository.CourseRepository;
import com.database.databasedemo.repository.PassportRepository;
import com.database.databasedemo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	PassportRepository passportRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		//Courses without students
		log.info("Courses without students: {}", courseRepository.findCoursesWithoutStudents().stream().map(Course::getName).toList());

		//Courses with at least 2 students
		log.info("Courses without students: {}", courseRepository.findCoursesWithAtLeastTwoStudents().stream().map(Course::getName).toList());

		//Courses ordered by students quantity
		log.info("Courses without students: {}", courseRepository.findCoursesOrderedByStudents().stream().map(Course::getName).toList());
	}
}

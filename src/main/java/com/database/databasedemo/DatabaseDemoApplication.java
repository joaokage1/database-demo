package com.database.databasedemo;

import com.database.databasedemo.entity.Course;
import com.database.databasedemo.entity.Passport;
import com.database.databasedemo.entity.Review;
import com.database.databasedemo.entity.Student;
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

		//Adding student with passport
		Passport toddyPassport = new Passport("T999");
		passportRepository.save(toddyPassport);

		Student toddy = Student.builder()
				.name("Toddy")
				.passport(toddyPassport)
				.active(true)
				.build();
		toddy = studentRepository.save(toddy);

		log.info("Student saved: {}", toddy.getName());

		Student joao = studentRepository.findById(20001L);
		log.info(joao.toString());
		log.info(joao.getPassport().toString());
		//Retrieve student with courses
		log.info("Courses from {}: {}", joao.getName(), joao.getCourses().stream().map(Course::getName).toList());

		//Adding course with review
		courseRepository.addReviewsForCourse(10001L, new Review("Top top","5"));

		//Retrieving course with students
		Course matematicaBasica = courseRepository.findById(10001L);
		log.info("Course: {} - Students: {} - Reviews: {}",
				matematicaBasica.getName(),
				matematicaBasica.getStudents().stream().map(Student::getName).toList(),
				matematicaBasica.getReviews().stream().map(review -> review.getDescription() +"|"+ review.getRating()).toList()
		);

		//Deleting with soft delete toddy
		Long toddyId = toddy.getId();
		studentRepository.deleteById(toddyId);
		log.info("User deleted {}: {}", toddyId, studentRepository.findById(toddyId));
	}
}

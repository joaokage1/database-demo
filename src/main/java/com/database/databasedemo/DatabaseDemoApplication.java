package com.database.databasedemo;

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
				.build();
		toddy = studentRepository.save(toddy);

		log.info("Student saved: {}", toddy);

		Student test = studentRepository.findById(20001L);
		log.info(test.toString());
		log.info(test.getPassport().toString());

		//Adding course with review
		courseRepository.addReviewsForCourse(10001L, new Review("Top top","5"));
	}
}

package com.database.databasedemo;

import com.database.databasedemo.entity.Course;
import com.database.databasedemo.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		log.info("Course by id 10001: {}", courseRepository.findById(10001L).orElseThrow().getName());
		log.info("All courses {}",courseRepository.findAll().stream().map(Course::getName).toList());
		courseRepository.save(Course.builder().name("Biologia").build());
		log.info("All courses after inserting {}",courseRepository.findAll(Sort.by("name").ascending()).stream().map(Course::getName).toList());
		log.info("All courses with name {}",courseRepository.findByName("Linguagens").stream().map(Course::getName).toList());
		log.info("All courses with básica in name {}",courseRepository.courseWithBasicName().stream().map(Course::getName).toList());
		log.info("All courses with básica in name natve {}",courseRepository.courseWithBasicNameNative().stream().map(Course::getName).toList());
	}
}

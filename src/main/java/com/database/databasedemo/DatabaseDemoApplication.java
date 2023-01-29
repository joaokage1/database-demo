package com.database.databasedemo;

import com.database.databasedemo.entity.Employee;
import com.database.databasedemo.entity.FullTimeEmployee;
import com.database.databasedemo.entity.PartTimeEmployee;
import com.database.databasedemo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		employeeRepository.insert(new FullTimeEmployee("Joao", BigDecimal.valueOf(10000)));
		employeeRepository.insert(new PartTimeEmployee("Jaque", BigDecimal.valueOf(50)));

		log.info("All full time employees: {}",employeeRepository.findAllFullTimeEmployee().stream().map(Employee::getName).toList());
		log.info("All part time employees: {}",employeeRepository.findAllPartTimeEmployee().stream().map(Employee::getName).toList());
	}
}

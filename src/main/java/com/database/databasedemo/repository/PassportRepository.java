package com.database.databasedemo.repository;

import com.database.databasedemo.entity.Passport;
import com.database.databasedemo.entity.Student;
import jakarta.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {

}

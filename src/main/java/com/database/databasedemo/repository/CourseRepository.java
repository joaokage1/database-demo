package com.database.databasedemo.repository;

import com.database.databasedemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

    @Query("Select c From Course c where name like '%Básica%'")//JPQL
    List<Course> courseWithBasicName();

    @Query(value = "Select * From Course c where name like '%Básica%'", nativeQuery = true)//Native Query
    List<Course> courseWithBasicNameNative();
}

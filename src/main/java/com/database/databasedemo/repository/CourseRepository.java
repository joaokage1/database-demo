package com.database.databasedemo.repository;

import com.database.databasedemo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    //Cares with entities - Less complex sql
    public List<Course> findCoursesWithoutStudents(){
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.students is empty", Course.class);
        return query.getResultList();
    }

    public List<Course> findCoursesWithAtLeastTwoStudents(){
        String sql = "select c from Course c where size(c.students) >= 2";
        TypedQuery<Course> query = entityManager.createQuery(sql, Course.class);
        return query.getResultList();
    }

    public List<Course> findCoursesOrderedByStudents(){
        String sql = "select c from Course c order by size(c.students) desc";
        TypedQuery<Course> query = entityManager.createQuery(sql, Course.class);
        return query.getResultList();
    }
}

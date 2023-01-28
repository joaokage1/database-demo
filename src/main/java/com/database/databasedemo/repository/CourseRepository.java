package com.database.databasedemo.repository;

import com.database.databasedemo.entity.Course;
import com.database.databasedemo.entity.Review;
import jakarta.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Log4j2
@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {

        if (Objects.isNull(course.getId())){
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        if (!Objects.isNull(course))
            entityManager.remove(course);
    }

    public void addReviewsForCourse(Long id, Review review) {
        Course course = findById(id);
        course.addReview(review);
        review.setCourse(course);
        entityManager.persist(review);

        log.info("Current reviews for course {}: {}", id, course.getReviews().stream().map(r -> r.getRating() + ": " + r.getDescription()).toList());
    }
}

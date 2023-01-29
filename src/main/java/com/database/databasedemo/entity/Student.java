package com.database.databasedemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    //*ToOne is always EAGER fetch
    // by default
    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    //*ToMany is always EAGER lazy
    // by default
    @Getter
    @ManyToMany
    @JoinTable(
            name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        this.getCourses().add(course);
    }

    public void removeReview(Course course){
        this.getCourses().remove(course);
    }
}

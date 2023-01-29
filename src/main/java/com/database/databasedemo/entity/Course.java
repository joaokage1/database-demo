package com.database.databasedemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

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

    @Getter
    @Setter
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @Getter
    @Setter
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Getter
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @Getter
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public void addReview(Review review){
        this.getReviews().add(review);
    }

    public void removeReview(Review review){
        this.getReviews().remove(review);
    }
}

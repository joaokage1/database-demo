package com.database.databasedemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    private String rating;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Review(String description, String rating){
        this.setDescription(description);
        this.setRating(rating);
    }
}

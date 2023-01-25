package com.database.databasedemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    //OneToOne is always EAGER fetch by default
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @Override
    public String toString() {
        return String.format("Student: %s", this.getName());
    }
}

package com.database.databasedemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(mappedBy = "passport")
    private Student student;

    public Passport(String number){
        this.setNumber(number);
    }

    @Override
    public String toString() {
        return String.format("Passport: %s", this.getNumber());
    }
}

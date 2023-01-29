package com.database.databasedemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
/*
 * --------------------------------------------------------------------
 * The Default strategy is InheritanceType.SINGLE_TABLE for inheritance
 * Null values with this
 * Good performance - Bad DB design
 * --------------------------------------------------------------------
 * The strategy InheritanceType.TABLE_PER_CLASS for inheritance creates
 * a table for concrete class.
 * uses a union to retrieve the details
 * Good performance - Bad DB design
 * --------------------------------------------------------------------
 * The strategy InheritanceType.JOINED only create tables for the fields
 * that are different from the abstract class
 * uses a join to instantiate the subclasses
 * Bad performance - Good DB design
 * */
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass //No table for superclass - Remove the relationship between the subclasses
public abstract class Employee {

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

    public Employee(String name){
        this.setName(name);
    }
}

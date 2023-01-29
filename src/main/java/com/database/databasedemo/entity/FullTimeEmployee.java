package com.database.databasedemo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
public class FullTimeEmployee extends Employee{
    @Getter
    @Setter
    private BigDecimal salary;

    protected FullTimeEmployee(){}

    public FullTimeEmployee(String name, BigDecimal salary){
        super(name);
        this.setSalary(salary);
    }
}

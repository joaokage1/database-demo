package com.database.databasedemo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
public class PartTimeEmployee extends Employee{
    @Getter
    @Setter
    private BigDecimal hourlyWage;

    protected PartTimeEmployee(){}

    public PartTimeEmployee(String name, BigDecimal hourlyWage){
        super(name);
        this.setHourlyWage(hourlyWage);
    }
}

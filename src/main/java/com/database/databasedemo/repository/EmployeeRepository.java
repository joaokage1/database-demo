package com.database.databasedemo.repository;

import com.database.databasedemo.entity.Employee;
import com.database.databasedemo.entity.FullTimeEmployee;
import com.database.databasedemo.entity.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    //Insert an employee
    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    //Retrieve all employees
    /*With inheritance "select e from Employee e"
     * public List<Employee> findAll(){
     *   return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
     * }
     */

    public List<FullTimeEmployee> findAllFullTimeEmployee(){
        return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

    public List<PartTimeEmployee> findAllPartTimeEmployee(){
        return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }
}

package com.olegyashcherov.springcourse.databaseunit_3;

import com.olegyashcherov.springcourse.databaseunit_3.entity.Department;
import com.olegyashcherov.springcourse.databaseunit_3.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_01 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            Employee employee = new Employee("Иван", "Иванов", 15000);
            Employee employee2 = new Employee("Олег", "Ящеров", 45000);

            Department department = new Department("IT", 10000, 150000);
            department.addEmployee(employee);
            department.addEmployee(employee2);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        }
    }
}

package com.olegyashcherov.springcourse.databaseunit_4;

import com.olegyashcherov.springcourse.databaseunit_4.entity.Department;
import com.olegyashcherov.springcourse.databaseunit_4.entity.Employee;
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

            Employee employee = new Employee("Юлия", "Пингвинова", 25000);
            Employee employee2 = new Employee("Антон", "Никитин", 25000);

            Department department = new Department("HR", 10000, 150000);
            department.addEmployee(employee);
            department.addEmployee(employee2);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        }
    }
}

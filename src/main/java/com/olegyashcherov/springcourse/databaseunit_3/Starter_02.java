package com.olegyashcherov.springcourse.databaseunit_3;

import com.olegyashcherov.springcourse.databaseunit_3.entity.Department;
import com.olegyashcherov.springcourse.databaseunit_3.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_02 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmployeeList());

            Employee employee = session.get(Employee.class, 5);
            System.out.println(employee);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();

        }
    }
}

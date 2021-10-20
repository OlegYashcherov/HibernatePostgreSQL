package com.olegyashcherov.springcourse.databaseunit_1;

import com.olegyashcherov.springcourse.databaseunit_1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Starter_03 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 2);

//            List<Employee> employeeList = session.createQuery("from Employee").getResultList();
            List<Employee> employeeList = session.createQuery("from Employee where name = 'Олег'").getResultList();

            session.getTransaction().commit();


            System.out.println(employeeList);
        }
    }
}

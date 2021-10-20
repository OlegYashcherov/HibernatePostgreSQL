package com.olegyashcherov.springcourse.databaseunit_1;

import com.olegyashcherov.springcourse.databaseunit_1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_02 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            session.getTransaction().commit();

            System.out.println(employee);
        } finally {
            factory.close();
        }
    }
}

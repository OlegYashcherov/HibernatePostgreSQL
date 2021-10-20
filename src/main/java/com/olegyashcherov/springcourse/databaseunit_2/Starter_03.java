package com.olegyashcherov.springcourse.databaseunit_2;

import com.olegyashcherov.springcourse.databaseunit_2.entity.Detail;
import com.olegyashcherov.springcourse.databaseunit_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_03 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            session.delete(employee);
            session.getTransaction().commit();

            System.out.println(employee);
        }
    }
}

package com.olegyashcherov.springcourse.databaseunit_1;

import com.olegyashcherov.springcourse.databaseunit_1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_05 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 2);
//            session.delete(employee);

            int i = session.createQuery("delete Employee").executeUpdate();
//            int i = session.createQuery("delete Employee where name = 'Олег'").executeUpdate();
            System.out.println("Number delete " + i);

            session.getTransaction().commit();

        }
    }
}

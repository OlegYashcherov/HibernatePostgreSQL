package com.olegyashcherov.springcourse.databaseunit_1;

import com.olegyashcherov.springcourse.databaseunit_1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_04 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            int i = session.createQuery("update Employee set salary = 50000").executeUpdate();
            int i = session.createQuery("update Employee set salary = 100001 where name = 'Олег'").executeUpdate();
            System.out.println("Number update " + i);
//            Employee employee = session.get(Employee.class, 2);
//            employee.setSalary(35000);

            session.getTransaction().commit();

        }
    }
}

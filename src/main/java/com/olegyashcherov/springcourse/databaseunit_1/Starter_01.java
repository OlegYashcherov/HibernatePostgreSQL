package com.olegyashcherov.springcourse.databaseunit_1;

import com.olegyashcherov.springcourse.databaseunit_1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_01 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Олег", "Ящеров", "ИТ", 100000);
            Employee employee2 = new Employee("Юлия", "Пингвинова", "Продажи", 10000);

            session.beginTransaction();
            session.save(employee);
            session.save(employee2);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

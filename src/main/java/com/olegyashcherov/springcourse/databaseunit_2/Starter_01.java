package com.olegyashcherov.springcourse.databaseunit_2;

import com.olegyashcherov.springcourse.databaseunit_2.entity.Detail;
import com.olegyashcherov.springcourse.databaseunit_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_01 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Олег", "Ящеров", "ИТ", 100000);
            Detail detail = new Detail("Rostov-on-Don", "928-956-50-05", "olegyashcherov@gmail.com");
            employee.setDetail(detail);

            Employee employee2 = new Employee("Юлия", "Пингвинова", "Продажи", 10000);
            Detail detail2 = new Detail("Rostov-on-Don", "903-464-8-03", "123@gmail.com");
            employee2.setDetail(detail2);

            session.beginTransaction();
            session.save(employee);
            session.save(employee2);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

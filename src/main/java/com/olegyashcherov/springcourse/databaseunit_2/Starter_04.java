package com.olegyashcherov.springcourse.databaseunit_2;

import com.olegyashcherov.springcourse.databaseunit_2.entity.Detail;
import com.olegyashcherov.springcourse.databaseunit_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_04 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

//            Employee employee = new Employee("Иван", "Иванов", "Склад", 15000);
//            Detail detail = new Detail("Rostov-on-Don", "928-987-65-43", "egov@gmail.com");
//            employee.setDetail(detail);
//            detail.setEmployee(employee);

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 3);

//            session.save(detail);

            session.getTransaction().commit();

            System.out.println(detail);
        }
    }
}

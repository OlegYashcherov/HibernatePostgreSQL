package com.olegyashcherov.springcourse.databaseunit_5;

import com.olegyashcherov.springcourse.databaseunit_5.entity.Child;
import com.olegyashcherov.springcourse.databaseunit_5.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Starter_01 {
    public static void main(String[] args) {

//        Section section1 = new Section("Футбол");
//        Section section2 = new Section("Бильярд");
//        Section section3 = new Section("Макраме");
//
//        Child child1 = new Child("Вася", 5);
//        Child child2 = new Child("Марк", 6);
//        Child child3 = new Child("Юля", 7);
//        Child child4 = new Child("Алиса", 8);
//        Child child5 = new Child("Демид", 6);
//
//        section1.addChildToSection(child1);
//        section1.addChildToSection(child2);
//        section1.addChildToSection(child5);
//
//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Child.class)
//                .addAnnotatedClass(Section.class)
//                .buildSessionFactory();
//             Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//
//            session.persist(section1);
//
//            session.getTransaction().commit();
//        }

//**************************************************************************

//        Section section1 = new Section("Шахматы");
//        Section section2 = new Section("Бильярд");
//        Section section3 = new Section("Макраме");
//
//        Child child3 = new Child("Юля", 7);
//
//        child3.addSectionToChild(section1);
//        child3.addSectionToChild(section2);
//        child3.addSectionToChild(section3);
//
//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Child.class)
//                .addAnnotatedClass(Section.class)
//                .buildSessionFactory();
//             Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//
//            session.persist(child3);
//
//            session.getTransaction().commit();
//        }

//**************************************************************************

//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Child.class)
//                .addAnnotatedClass(Section.class)
//                .buildSessionFactory();
//             Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildList());
//
//            session.getTransaction().commit();
//        }

        //**************************************************************************

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Child child = session.get(Child.class, 4);
            System.out.println(child);
            System.out.println(child.getSectionList());

            session.getTransaction().commit();
        }


    }
}

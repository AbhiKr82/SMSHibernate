package org.example.util;

import org.example.entities.Course;
import org.example.entities.Laptop;
import org.example.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try{
            if(sessionFactory==null){
                sessionFactory= new Configuration()
                        .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(Laptop.class)
                        .addAnnotatedClass(Course.class)
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();

            }

        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}

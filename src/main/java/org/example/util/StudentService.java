package org.example.util;

import org.example.entities.Course;
import org.example.entities.Laptop;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentService {

    private SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    Session session= sessionFactory.openSession();




    // To add Student to db
    public void saveStudent(Student student){
        Transaction  transaction= null;
        try{
            transaction= session.beginTransaction();
            session.persist(student);
            transaction.commit();
            System.out.println("Student Saved SuccessFully");

        }catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage());
        }

    }

    // add laptop to db
    public void saveLaptop(Laptop laptop){
        Transaction transaction=null;
        try{
            transaction= session.beginTransaction();
            session.persist(laptop);
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null) transaction.rollback();
            throw new RuntimeException(e);
        }
    }

//    add Course to db
public void saveCourse(Course course){
    Transaction transaction=null;
    try{
        transaction= session.beginTransaction();
        session.persist(course);
        transaction.commit();
    } catch (Exception e) {
        if(transaction!=null) transaction.rollback();
        throw new RuntimeException(e);
    }
}

    //Retrieve Student -> all
    public List<Student> getAllStudent(){

        try{
            List<Student> studentList= session.createQuery("from Student", Student.class).getResultList();
            return studentList;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }

//    --> by ID

    public Student getStudentByID(String id){

        try{
            Student student= session.find(Student.class,id);
            return  student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

//    --> query

    public List<Student> getByQuery(String query){
        try{
            List<Student> studentList= session.createQuery(query, Student.class).getResultList();
            return studentList;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }


    //Update

    public Student UpdateStudent(String id,Student newStudent){
        Transaction  transaction=null;
        try{
            transaction= session.beginTransaction();
            Student oldStudent= session.find(Student.class,id);
            oldStudent.setBranch(newStudent.getBranch());
            oldStudent.setCgpa(newStudent.getCgpa());
            oldStudent.setName(newStudent.getName());
            oldStudent.setEmail(newStudent.getEmail());
            oldStudent.setGender(newStudent.getGender());
            oldStudent.setPhone(newStudent.getPhone());

            session.merge(oldStudent);
            transaction.commit();
            return oldStudent;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;

        }
    }


    // Delete
    public String delete(String Id){

        Transaction  transaction=null;
        try{
            transaction=session.beginTransaction();
            Student student= session.find(Student.class,Id);

            if(student==null){
                return "Student Not found";
            }
            session.remove(student);

            transaction.commit();
            return "deleted successfully";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "Something Went Wrong";
        }

    }







}

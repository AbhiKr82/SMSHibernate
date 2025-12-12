package org.example;
import org.example.entities.Course;
import org.example.entities.Laptop;
import org.example.entities.Student;
import org.example.util.StudentService;

import java.util.Arrays;



public class App 
{
    public static void main( String[] args )
    {

        StudentService service= new StudentService();

        Course c1= new Course("CS101","DSA",6,"S.V Ready");
        Course c2= new Course("CS102","Python",4,"K.S. Gupta");
        Course c3= new Course("DS101","Probability",6,"M.S.Kumar");
        Course c4= new Course("EC101","Digital & Analog",6,"S.K Murty");
        Course c5= new Course("EC102","VLSI",6,"M.S Mohan");
        Course c6= new Course("ME101","Mechanics",6,"S.S Kumar");

        service.saveCourse(c1);
        service.saveCourse(c2);
        service.saveCourse(c3);
        service.saveCourse(c4);
        service.saveCourse(c5);
        service.saveCourse(c6);



        Laptop l1= new Laptop(103,"DELL","XPS",32);
        Laptop l2= new Laptop(101,"HP","Pavilion",32);
        Laptop l3= new Laptop(102,"Apple","Mw",16);

        service.saveLaptop(l1);
        service.saveLaptop(l3);
        service.saveLaptop(l2);




        Student s1= new Student("122CS0049","Abhimanyu Kumar ","Male","CSE",7.10,"122CS0049@gmail.com","6734125890");
        Student s2= new Student("122EC0034","Vishal Kumar ","Male","ECE",7.40,"122EC0034@gmail.com","2589067341");
        Student s3= new Student("122CS0044","Rohit Kumar ","Male","CSE",8.40,"122CS0044@gmail.com","6739041258");

        s1.setLaptop(l3);
        s2.setLaptop(l1);
        s3.setLaptop(l2);

        s1.setCourseList(Arrays.asList(c1,c2,c3));
        s2.setCourseList(Arrays.asList(c3,c4,c5));
        s3.setCourseList(Arrays.asList(c1,c2,c3));


        service.saveStudent(s1);
        service.saveStudent(s2);
        service.saveStudent(s3);











    }
}

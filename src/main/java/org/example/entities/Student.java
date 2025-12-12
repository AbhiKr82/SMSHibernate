package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String id;
    private String name;
    private String gender;
    private String branch;
    private double cgpa;
    private String email;
    private String phone;

    @OneToOne
    private Laptop laptop;

    @ManyToMany
    private List<Course> courseList;

    public Student() {
    }

    public Student(String id, String name, String gender, String branch, double cgpa, String email, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.branch = branch;
        this.cgpa = cgpa;
        this.email = email;
        this.phone = phone;

    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getId() {
        return id;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "[" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", branch='" + branch + '\'' +
                ", cgpa=" + cgpa +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ']';
    }
}

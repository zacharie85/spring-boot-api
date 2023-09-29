package com.springapi.student;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Objects;

@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique",columnNames = "email")
        }
)
@Entity(name="Student")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_id_sequence",
            sequenceName = "student_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String first_name;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String last_name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String email;
    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;
    public Student() {

    }

    public Student(String first_name,String last_name,String email,Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id,student.id) && Objects.equals(first_name,student.first_name) && Objects.equals(last_name,student.last_name) && Objects.equals(email,student.email) && Objects.equals(age,student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,first_name,last_name,email,age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

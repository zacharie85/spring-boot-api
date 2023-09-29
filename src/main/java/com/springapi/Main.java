package com.springapi;

import com.github.javafaker.Faker;
import com.springapi.student.Student;
import com.springapi.student.StudentIdCard;
import com.springapi.student.StudentIdCardRepository;
import com.springapi.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository) {
        return args -> {
           // generateStudent(studentRepository);
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@reactcode.edu", firstName, lastName);
            Student student = new Student(
                        firstName,
                        lastName,
                        email,
                        faker.number().numberBetween(17, 55));
           // studentRepository.save(student);
           StudentIdCard studentIdCard = new StudentIdCard("1234566", student);
            studentIdCardRepository.save(studentIdCard);
        };
    }

    private  void generateStudent(StudentRepository studentRepository,
                                  StudentIdCardRepository studentIdCardRepository) {
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@reactcode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            studentRepository.save(student);
        }
    }
}

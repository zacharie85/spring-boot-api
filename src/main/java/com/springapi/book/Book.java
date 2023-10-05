package com.springapi.book;

import com.springapi.student.Student;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name="book")
@Entity(name = "Book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "book_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String book_name;
    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="student_id_fk")
    )
    private Student student;

    public Book(String book_name,LocalDateTime created_at) {
        this.book_name = book_name;
        this.created_at = created_at;
    }

    public Book() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id,book.id) && Objects.equals(book_name,book.book_name) && Objects.equals(created_at,book.created_at) && Objects.equals(student,book.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,book_name,created_at,student);
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", created_at=" + created_at +
                ", student=" + student +
                '}';
    }

    public Object getBookName() {
        return  book_name;
    }
}

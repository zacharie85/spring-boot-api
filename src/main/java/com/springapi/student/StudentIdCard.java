package com.springapi.student;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "StudentIdCard")
@Table(
        name="student_id_card",
        uniqueConstraints = {
        @UniqueConstraint(name = "student_cardNumber_unique",columnNames = "cardNumber"
        )
}
)
public class StudentIdCard {
    @Id
    @SequenceGenerator(
            name = "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_card_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "cardNumber",
            nullable = false,
            length = 15
    )
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="student_id_fk")
    )
    private  Student student;
    public StudentIdCard() {

    }

    public StudentIdCard(String cardNumber,Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public StudentIdCard(Long id,String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentIdCard that = (StudentIdCard) o;
        return Objects.equals(id,that.id) && Objects.equals(cardNumber,that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,cardNumber);
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}

package ru.lanit.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="user", schema = "public")
public class User {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastName;
    private BigInteger age;
    private BigInteger gender;
    /*private Doctor doctor;*/
    private Collection<Rx> rxes;
    private int role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 250)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 20)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "age", nullable = true, precision = 0)
    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    @Basic
    @Column(name = "gender", nullable = true, precision = 0)
    public BigInteger getGender() {
        return gender;
    }

    public void setGender(BigInteger gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(age, user.age) &&
                Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstname, lastName, age, gender);
    }

   /* @OneToOne(mappedBy = "user")
    public Doctor getDoctor() {
        return doctor;
    }*/

   /* public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }*/

    /*@OneToMany(mappedBy = "user")
    public Collection<Rx> getRxes() {
        return rxes;
    }*/

    public void setRxes(Collection<Rx> rxes) {
        this.rxes = rxes;
    }
    public void addRx(Rx rx){
        rxes.add(rx);
    }



    @Basic
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}

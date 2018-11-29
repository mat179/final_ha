package ru.lanit.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Rx {
    private int id;
    private String symptoms;
    private String medicine;
    private Date createTime;
    private Date lastUpdated;
    private User user;
    private Doctor doctor;

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
    @Column(name = "symptoms", nullable = true, length = 250)
    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Basic
    @Column(name = "medicine", nullable = true, length = 250)
    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_updated", nullable = false)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @PrePersist
    protected void onCreate() {
        createTime = lastUpdated = Date.valueOf(LocalDate.now());
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = Date.valueOf(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rx rx = (Rx) o;
        return id == rx.id &&
                Objects.equals(symptoms, rx.symptoms) &&
                Objects.equals(medicine, rx.medicine) &&
                Objects.equals(createTime, rx.createTime) &&
                Objects.equals(lastUpdated, rx.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symptoms, medicine, createTime, lastUpdated);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

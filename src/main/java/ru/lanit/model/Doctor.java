package ru.lanit.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "doctor")
public class Doctor {
    private int id;
    private String specialityCode;
    private Date createTime;
    private Date lastUpdated;
    private User user;
    private Collection<Rx> rxes;

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
    @Column(name = "speciality_code", nullable = false, length = 20)
    public String getSpecialityCode() {
        return specialityCode;
    }

    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
    }

    @Basic
    @Column(name = "create_time", nullable = false, updatable = false, insertable = false)
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
    public int hashCode() {
        return Objects.hash(id, specialityCode, createTime, lastUpdated);
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setRxes(Collection<Rx> rxes) {
        this.rxes = rxes;
    }
}

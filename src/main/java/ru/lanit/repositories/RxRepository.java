package ru.lanit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lanit.model.Rx;

import java.util.List;

public interface RxRepository extends JpaRepository<Rx,Integer> {
    public List<Rx> findByDoctorId(int id);
    public List<Rx> findByUserId(int id);
}

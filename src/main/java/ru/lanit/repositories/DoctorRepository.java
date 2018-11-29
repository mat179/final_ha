package ru.lanit.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.lanit.model.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

     public List findBySpecialityCode(String code);
     public Doctor findByUserEmail(String email);
     public Doctor findByUserId(int id);

}

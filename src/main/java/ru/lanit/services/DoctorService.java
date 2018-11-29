package ru.lanit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.model.Doctor;
import ru.lanit.model.User;
import ru.lanit.repositories.DoctorRepository;
import java.util.List;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void save(Doctor doc){
        doctorRepository.save(doc);
    };
    public List findBySpeciality(String code){
        return doctorRepository.findBySpecialityCode(code);
    }
    public List findAll(){
        return doctorRepository.findAll();
    }
    public Doctor findByUserEmailAddress(String email){
        return doctorRepository.findByUserEmail(email);
    }
    public int findCount(){
        return findAll().size();
    }
    public Doctor findByUserId(int id){
        return doctorRepository.findByUserId(id);
    }
    public void addDoctor(User user){
        if (user.getRole()==1) {
            Doctor doc = new Doctor();
            doc.setUser(user);
            doc.setSpecialityCode("PHYSICIAN");
            save(doc);
        }
    }



}

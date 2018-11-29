package ru.lanit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.model.Rx;
import ru.lanit.repositories.RxRepository;

import java.util.List;

@Service
@Transactional
public class RxService {
    @Autowired
    RxRepository repository;

    public void save(Rx rx) {
        repository.save(rx);
    }
    public List<Rx> finByDoctorId(int id){
        return repository.findByDoctorId(id);
    }
    public List<Rx> finByUserId(int id){
        return repository.findByUserId(id);
    }

    public List<Rx> getRxes(){
        return repository.findAll();
    }

}

package ru.lanit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lanit.model.Doctor;
import ru.lanit.repositories.DoctorRepository;
import ru.lanit.services.DoctorService;
import ru.lanit.utils.DoctorInfo;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorSearchController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getDoctorCount(){
            return doctorService.findAll().size();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List findAll(){
        return doctorService.findAll();
    }

    @GetMapping
    public DoctorInfo getDoctors(){
        List<Doctor> docs =  doctorService.findAll();
        if (docs==null || docs.size()==0){
            DoctorInfo info = new DoctorInfo("No Doctors found!",null);
            return info;
        }
        DoctorInfo info = new DoctorInfo("Doctors found", docs );
        return info;
    }
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public DoctorInfo getBySpecialityCode(@PathVariable String code){
        List<Doctor> docs =  doctorService.findBySpeciality(code);
        if (docs==null || docs.size()==0){
            DoctorInfo info = new DoctorInfo("No Doctors found!",null);
            return info;
        }
        DoctorInfo info = new DoctorInfo("Doctors found", docs );
        return info;
    }

}

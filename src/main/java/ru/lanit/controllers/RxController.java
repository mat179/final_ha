package ru.lanit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.lanit.exceptions.UserNotFoundException;
import ru.lanit.model.Doctor;
import ru.lanit.model.Rx;
import ru.lanit.model.User;
import ru.lanit.services.DoctorService;
import ru.lanit.services.RxService;
import ru.lanit.services.UserService;
import ru.lanit.utils.RxDTO;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rx")
public class RxController {
    @Autowired
    RxService rxService;
    final static Logger logger = LoggerFactory.getLogger(RxController.class);


    @Autowired
    UserService userService;

    @Autowired
    DoctorService docService;


    @GetMapping
    public List<RxDTO> getRx(){
        List<Rx> rxList = new ArrayList<>();
        List<RxDTO> rxDTOS = new ArrayList<>();
        User user = getUser();
        if (user.getRole()==1){
            rxList = rxService.finByDoctorId(docService.findByUserId(user.getId()).getId());
        } else {
            rxList = rxService.finByUserId(user.getId());
        }
        rxList.forEach(rx -> rxDTOS.add(new RxDTO(rx.getUser().getFirstname(),
                                                  rx.getSymptoms(),
                                                  rx.getMedicine())));
        return rxDTOS;
    }

    @PostMapping("/new")
    public Rx createRx(@RequestBody RxDTO rxDTO){
        Rx rx = new Rx();
        rx.setMedicine(rxDTO.getMedicine());
        rx.setSymptoms(rxDTO.getSymptoms());
        User user = null;
        try {
            user = userService.getByEmail(rxDTO.getPatientId());
        } catch (UserNotFoundException e){
            logger.error("Пользователь не найден: "+rxDTO.getPatientId());
        }
        rx.setUser(user);
        Doctor doc = docService.findByUserEmailAddress(getUserEmailAddress());
        rx.setDoctor(doc);
        rxService.save(rx);
        return rx;

    }

    @GetMapping("/doctor/{id}")
    public List getByDoctorId(@PathVariable int id){
        return  rxService.finByDoctorId(id);
    }

    private User getUser(){
        String email = getUserEmailAddress();
        User user =null;
        try {
            user = userService.doesUserExist(email);
        } catch (UserNotFoundException e){
            logger.error("Пользователь не найден: "+email);
        }
        return user;
    }

    private String getUserEmailAddress(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails details = (UserDetails) auth.getPrincipal();
        return details.getUsername();
    }
}

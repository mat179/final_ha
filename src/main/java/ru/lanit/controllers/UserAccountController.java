package ru.lanit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lanit.exceptions.UserNotFoundException;
import ru.lanit.model.User;
import ru.lanit.services.DoctorService;
import ru.lanit.services.UserService;
import ru.lanit.utils.ExecutionStatus;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class UserAccountController {
    final static Logger logger = LoggerFactory.getLogger(UserAccountController.class);

    UserService userService;
    DoctorService docService;

    @Autowired
    public UserAccountController(UserService userService, DoctorService docService) {
        this.userService = userService;
        this.docService = docService;
    }
    @GetMapping("/token")
    public Map getToken(HttpSession session){
        return Collections.singletonMap("token",session.getId());
    }
    @PostMapping("/signup")
    public ExecutionStatus process(@RequestBody User user){
       try {
           if (userService.doesUserExist(user.getEmail())!=null){
               logger.error("Пользователь уже существует: "+user.getEmail());
               return new ExecutionStatus("-1000","Пользователь существует");
           }
       } catch (UserNotFoundException e){

       }
       User newUser = new User();
       newUser.setEmail(user.getEmail());
       newUser.setAge(user.getAge());
       newUser.setFirstname(user.getFirstname());
       newUser.setGender(user.getGender());
       newUser.setLastName(user.getLastName());
       newUser.setPassword(user.getPassword());
       newUser.setRole(user.getRole());
       userService.save(newUser);
       docService.addDoctor(newUser);
       logger.info("Пользователь создан: "+newUser.getEmail());
       return new ExecutionStatus("0","Пользователь создан", newUser);
    }


}

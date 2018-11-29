package ru.lanit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.exceptions.UnmatchingUserCredentialsException;
import ru.lanit.exceptions.UserNotFoundException;
import ru.lanit.model.User;
import ru.lanit.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository repository;

    public User save(User user) {
       return repository.save(user);
    }
    public User getByEmail(String email) throws UserNotFoundException{
        return doesUserExist(email);
    }

    public User doesUserExist(String email) throws UserNotFoundException {
        List<User> list = new ArrayList<>();
        list.add(repository.findByEmail(email));
        if(list.size() == 0) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return list.get(0);
    }
    public User isValidUser(String email, String password) throws UnmatchingUserCredentialsException {
        List<User> list = new ArrayList<>();
        list.add(repository.findByEmailAndPassword(email, password));
        if(list == null || list.size() == 0) {
            throw new UnmatchingUserCredentialsException("Пользователь не найден");
        }
        return list.get(0);
    }
}

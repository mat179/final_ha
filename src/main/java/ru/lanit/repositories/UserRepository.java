package ru.lanit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lanit.model.User;


public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
    public User existsUserByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
}

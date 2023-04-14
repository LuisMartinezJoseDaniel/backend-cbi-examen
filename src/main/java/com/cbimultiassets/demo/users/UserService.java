package com.cbimultiassets.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void registerNewUser(User user) {
        this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = this.userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El usuario con el id " + id + " no existe");
        }
        this.userRepository.deleteById(id);
    }


}

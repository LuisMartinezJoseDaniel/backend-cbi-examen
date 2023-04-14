package com.cbimultiassets.demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }


    public List<Authentication> getUsersWithRoles() {
        return authenticationRepository.findAll();
    }

    public void registerNewUser(Authentication authentication) {
        Optional<Authentication> optionalAuthentication = this.authenticationRepository.findAuthenticationByUsuario(authentication.getUsuario());
        if(optionalAuthentication.isPresent()){
            throw new IllegalStateException("El nombre de usuario ya ha sido tomado");
        }


        this.authenticationRepository.save(authentication);
    }

    public void deleteUser(Long userId) {
        boolean exists = this.authenticationRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("El usuario con el id " + userId + "no existe");
        }
        this.authenticationRepository.deleteById(userId);
    }
}

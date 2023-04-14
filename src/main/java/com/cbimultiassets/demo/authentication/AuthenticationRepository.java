package com.cbimultiassets.demo.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

    Optional<Authentication> findAuthenticationByUsuario(String usuario);

}

package com.cbimultiassets.demo.rol;

import com.cbimultiassets.demo.users.User;
import com.cbimultiassets.demo.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RolConfig {
    @Bean
    CommandLineRunner commandLineRunner(RolRepository repository){
        return args -> {
            Rol rolAdmin= new Rol(
                    "Administrador",
                    "Usuario con permisos de administrador"

            );
            Rol rolUsuario= new Rol(
                    "Usuario",
                    "Usuario con permisos limitados"

            );


            repository.saveAll(List.of(rolAdmin, rolUsuario));
        };
    }
}

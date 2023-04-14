package com.cbimultiassets.demo.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    private final RolRepository rolRepository;


    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }


    public List<Rol> getRoles() {
        return rolRepository.findAll();
    }

    public void registerNewRol(Rol rol) {
        this.rolRepository.save(rol);
    }

    public void deleteRol(Long id) {
        boolean exists = this.rolRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El rol con el id " + id + " no existe");
        }
        this.rolRepository.deleteById(id);
    }
}

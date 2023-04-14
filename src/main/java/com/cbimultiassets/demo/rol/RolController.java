package com.cbimultiassets.demo.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping(path = "/api/v1/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> getRoles() {
        return rolService.getRoles();
    }

    @PostMapping
    public void registerNewRol(@RequestBody Rol rol) {
        this.rolService.registerNewRol(rol);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRol(@PathVariable("id") Long id) {
        this.rolService.deleteRol(id);
    }

}

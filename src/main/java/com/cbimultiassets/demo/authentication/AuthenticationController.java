package com.cbimultiassets.demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping(path = "/api/v1/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public List<Authentication> getUsersWithRoles() {
        return authenticationService.getUsersWithRoles();
    }

    @PostMapping
    public void registerNewUser(@RequestBody Authentication authentication) {
        this.authenticationService.registerNewUser(authentication);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.authenticationService.deleteUser(id);
    }

}

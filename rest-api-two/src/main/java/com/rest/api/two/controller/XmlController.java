package com.rest.api.two.controller;

import com.rest.api.two.entity.Users;
import com.rest.api.two.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path = "/xml", produces = "application/xml")
@RequestMapping(path = "/api", produces = "application/xml")
public class XmlController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create-xml")
    public ResponseEntity<Users> createUserInXml(@RequestBody Users user) {
        try {
            Users user1 = userRepository.save(new Users(user.getName(), user.getAge()));
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/get-xml")
    public ResponseEntity<Users> getUserInXml() {
        Users user = new Users();
        user.setId(1L);
        user.setName("Himanshu Kumar");
        user.setAge(10);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }


}

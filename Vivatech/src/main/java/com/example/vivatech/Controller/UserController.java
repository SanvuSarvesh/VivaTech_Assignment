package com.example.vivatech.Controller;

import com.example.vivatech.Model.User;
import com.example.vivatech.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userProfiles")
public class UserController {

    @Autowired
    private UserRepository userProfileRepository;


    @PostMapping("/add-user")
    public ResponseEntity<User> createUserProfile(@RequestBody User userProfile) {
        User createdUserProfile = userProfileRepository.save(userProfile);
        return new ResponseEntity<>(createdUserProfile, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long id) {
        User userProfile = userProfileRepository.findById(id).orElse(null);
        if (userProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUserProfile(@PathVariable Long id) {
        User userProfile = userProfileRepository.findById(id).orElse(null);
        if (userProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userProfileRepository.delete(userProfile);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

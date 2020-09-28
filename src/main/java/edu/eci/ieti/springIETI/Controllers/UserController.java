package edu.eci.ieti.springIETI.Controllers;

import edu.eci.ieti.springIETI.Services.UserService;
import edu.eci.ieti.springIETI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user),HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> removeUser(@PathVariable String id){

        if (!(userService.getById(id) == null)){
            userService.remove(id);
            return new ResponseEntity<>("User "+id+ " Removed Successfully",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("User "+id+ " Doesn't exist",HttpStatus.ACCEPTED);
        }

    }

}

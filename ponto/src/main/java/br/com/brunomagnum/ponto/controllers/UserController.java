package br.com.brunomagnum.ponto.controllers;

import br.com.brunomagnum.ponto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.brunomagnum.ponto.services.UserService;

import javax.validation.Valid;

@RestController()
@RequestMapping("/usuario")
public class UserController {
    
    @Autowired
    UserService userService;
  
    @PostMapping()
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
      try{
          return ResponseEntity.status(201).body(userService.create(user));
      } catch (RuntimeException exception) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
      }
    }

    @GetMapping()
    public Iterable<User> findAll() throws Exception {
        try{
            return userService.findAll();
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }

    }
  
    @GetMapping("/{id}")
    public User findById(@PathVariable(name="id") int id) throws Exception{
        try {
            return userService.findById(id);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
  
    @PutMapping("/{id}")
    public User update(@PathVariable(name="id") int id, @RequestBody User newUser) throws Exception{
      try {
        return userService.update(id, newUser);
      } catch (RuntimeException exception){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
      }
    }
}
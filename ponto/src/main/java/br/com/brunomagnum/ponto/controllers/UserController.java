package br.com.brunomagnum.ponto.controllers;

import br.com.brunomagnum.ponto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.brunomagnum.ponto.services.UserService;

@RestController()
@RequestMapping("/usuario")
public class UserController {
    
    @Autowired
    UserService userService;
  
    @PostMapping()
    public User create(@RequestBody User user) {
      return userService.create(user);
    }

    @GetMapping()
    public Iterable<User> findAll() {
      return userService.findAll();
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
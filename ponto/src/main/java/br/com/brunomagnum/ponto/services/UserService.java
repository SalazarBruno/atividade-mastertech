package br.com.brunomagnum.ponto.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunomagnum.ponto.models.User;
import br.com.brunomagnum.ponto.repositories.UserRepository;



@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User create(@Valid User user) {
    return userRepository.save(user);
  }

  public Iterable<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Integer id) throws Exception {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new Exception("Usuário não encontrado");
    }
  }

  public User update(int id, @Valid User newUser) throws Exception {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      user.setName(newUser.getName());
      user.setEmail(newUser.getEmail());
      user.setCpf(newUser.getCpf());
      return userRepository.save(user);
    } else {
      throw new Exception("Usuário não encontrado");
    }
  }
}
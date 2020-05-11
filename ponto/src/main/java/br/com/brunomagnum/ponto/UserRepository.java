package br.com.brunomagnum.ponto;

import org.springframework.data.repository.CrudRepository;

import br.com.brunomagnum.ponto.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
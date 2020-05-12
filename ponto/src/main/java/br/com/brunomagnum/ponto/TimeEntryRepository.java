package br.com.brunomagnum.ponto;

import org.springframework.data.repository.CrudRepository;

import br.com.brunomagnum.ponto.TimeEntry;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TimeEntryRepository extends CrudRepository<TimeEntry, Integer> {
	public Iterable<TimeEntry> findByUserId(String userId);

}
/*package br.com.brunomagnum.ponto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import br.com.brunomagnum.ponto.models.TimeEntry;
import br.com.brunomagnum.ponto.models.User;
import br.com.brunomagnum.ponto.repositories.TimeEntryRepository;
import br.com.brunomagnum.ponto.repositories.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/ponto")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TimeEntryRepository timeEntryRepository;

	@PostMapping(path = "/addUser") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam final String name, @RequestParam final String cpf,
			@RequestParam final String email, @RequestParam final Date date) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setCpf(cpf);
		n.setEmail(email);
		n.setDate(date);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/listAllUsers")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}


	@GetMapping("user/{id}")
	public @ResponseBody Optional<User> findById(@PathVariable("id") Integer id) {
    	if (userRepository.existsById(id)) {
			return userRepository.findById(id);
		} else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Usuario não encontrado");
		}		
	}
	
	@PutMapping("editUser/{id}")
	public @ResponseBody String updateById(@PathVariable("id") Integer id, 
	@RequestParam(required = false) final String name,
	@RequestParam(required = false) final String cpf,
	@RequestParam(required = false) final String email) {
		if (userRepository.existsById(id)) {
			User u = userRepository.findById(id).get();
			if (null != name) {
				u.setName(name);
			}
			if (null != cpf) {
				u.setCpf(cpf);
			}
			if (null != email) {
				u.setEmail(email);
			}
			userRepository.save(u);
			return "Updated";
		} else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Usuario não encontrado");
		}		
	}

//Entradas de ponto
	@GetMapping(path="/listAllTimeEntries")
	public @ResponseBody Iterable<TimeEntry> getAllTimeEntry() {
		// This returns a JSON or XML with the entries
		return timeEntryRepository.findAll();
	}

	@GetMapping(path="listTimeEntries/{userId}")
	public @ResponseBody Iterable<TimeEntry> findByUserId(@PathVariable("userId") String userId) {
    	if (userRepository.existsById(Integer.parseInt(userId))) {
			return timeEntryRepository.findByUserId(userId);
		} else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Usuario não encontrado");
		}
	}

	@PostMapping(path="addTimeEntry") // Map ONLY POST Requests
	public @ResponseBody String addTimeEntry(@RequestParam final String idUser, @RequestParam final String type) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		TimeEntry te = new TimeEntry();
		te.setUser(idUser);
		if (!type.matches("in|out")) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "tipo de registro inválido, use in ou out");
		}
		te.setType(type);
		te.setDate(LocalDateTime.now());
		timeEntryRepository.save(te);
		return "Saved";
	}

}
*/
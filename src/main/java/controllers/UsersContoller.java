package controllers;

import model.ToDo;
import model.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import services.UsersService;
import enums.Continent;
import enums.Type;

/**
 * @author antoan
 *
 *         UsersController that is used like REST. Uses usersService
 */
@Controller
@RequestMapping("/user")
public class UsersContoller {

	public UsersService usersServce;

	//just for test
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseBody
	public String showIndex() {
		return "Ping Succeeded!";
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public Users findById(@RequestParam int id) {
		return usersServce.findById(id);
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	@ResponseBody
	public Users findByName(@RequestParam String name) {
		return usersServce.findByName(name);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createUser(int id, String name, Type type, Continent continent, String country, String userName, String password) {
		usersServce.createUser(id, name, type, continent, country, userName, password);
		return new ResponseEntity<>("user created", HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ToDo listAllUsers() {
		return usersServce.listAllUsers();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam int id) {
		usersServce.delete(id);
		return new ResponseEntity<>("user deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> update(@RequestParam Users user) {
		usersServce.update(user);
		return new ResponseEntity<>("user updated", HttpStatus.OK);
	}

}

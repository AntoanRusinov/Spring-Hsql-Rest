package services;

import model.ToDo;
import model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import repository.interfaces.UsersRepository;
import enums.Continent;
import enums.Type;
/**
 * @author antoan
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	protected UsersRepository usersRepository;

	@Autowired
	public Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Users findById(int id) throws DataAccessException {
		return usersRepository.findById(id);
	}

	public Users findByName(String name) throws DataAccessException {
		return usersRepository.findByName(name);
	}

	public void save(Users user) {
		usersRepository.save(user);
	}

	public ToDo listAllUsers() {
		return usersRepository.listAllUsers();
	}

	public void update(Users user) {
		usersRepository.update(user);
	}

	public void createUser(int id, String name, Type type, Continent continent, String country, String userName, String password) {
		usersRepository.create(id, name,  type,  continent,  country,  userName,  password);
	}

	public void delete(int id) {
		usersRepository.delete(id);
	}

}

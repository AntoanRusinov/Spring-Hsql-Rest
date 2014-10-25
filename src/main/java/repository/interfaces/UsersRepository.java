package repository.interfaces;

import model.ToDo;
import model.Users;

import org.springframework.dao.DataAccessException;

import enums.Continent;
import enums.Type;
/**
 * @author antoan
 */
public interface UsersRepository {

	Users findById(int id) throws DataAccessException;

	Users findByName(String name) throws DataAccessException;

	void save(Users user);

	void create(int id, String name, Type type, Continent continent, String country, String userName, String password);

	ToDo listAllUsers();

	void update(Users user);

	void delete(int id);

}
package repository.interfaces;

import model.ToDo;

import org.springframework.dao.DataAccessException;
/**
 * @author antoan
 */
public interface ToDoRepository {

	ToDo findById(int id) throws DataAccessException;

	void save(ToDo toDo);

	void update(ToDo toDo);

	void delete(int id);

	ToDo listAll();
	
	void create(int id, String content);

}

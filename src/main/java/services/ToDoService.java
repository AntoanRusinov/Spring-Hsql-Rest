package services;

import model.ToDo;

import org.springframework.dao.DataAccessException;
/**
 * @author antoan
 */
public interface ToDoService {

	ToDo findById(int id) throws DataAccessException;

	void save(ToDo toDo);

	void update(ToDo toDo);

	void delete(int id);

	ToDo listAll();

	void createToDo(int id, String content);
	
}

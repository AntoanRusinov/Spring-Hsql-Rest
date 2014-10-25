package services;

import model.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import repository.interfaces.ToDoRepository;
/**
 * @author antoan
 */
@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	protected ToDoRepository toDoRepository;

	public ToDo findById(int id) throws DataAccessException {
		return this.toDoRepository.findById(id);
	}

	public void save(ToDo toDo) {
		this.toDoRepository.save(toDo);
	}

	public void update(ToDo toDo) {
		this.toDoRepository.update(toDo);
	}

	public ToDo listAll() {
		return this.toDoRepository.listAll();
	}

	public void delete(int id) {
		this.toDoRepository.delete(id);
	}

	public void createToDo(int id, String content) {
		this.toDoRepository.create(id, content);
	}

}
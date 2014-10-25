package repository.impl.jpa;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.ToDo;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import repository.interfaces.ToDoRepository;

/**
 * @author antoan
 */
@Repository
public class JpaToDoRepositoryImpl implements ToDoRepository {

	@PersistenceContext
	EntityManager entityManager;

	public ToDo findById(int id) throws DataAccessException {
		Query query = entityManager.createQuery("SELECT to_do_id FROM to_do todo WHERE todo.to_do_id =:to_do_id");
		query.setParameter(id, "to_do_id");
		return (ToDo) query.getSingleResult();
	}

	public void save(ToDo toDo) {
		this.entityManager.persist(toDo);
	}

	public void update(ToDo toDo) {
		this.entityManager.merge(toDo);
	}

	public void delete(int id) {
		Query query = entityManager.createQuery("DELETE FROM to_do todo WHERE todo.to_do_id =:to_do_id");
		query.setParameter(id, "to_do_id");
		entityManager.refresh(query);
		this.entityManager.flush();
	}

	public ToDo listAll() {
		Query query = entityManager.createQuery("SELECT todo FROM to_do todo ORDER BY todo.to_do_id");
		return (ToDo) query.getResultList();
	}

	public void create(int id, String content) {
		ToDo todo = new ToDo();
		todo.setTo_do_id(id);
		todo.setContent(content);
		todo.setLastModifiedDate(new Timestamp(System.currentTimeMillis()));
		entityManager.persist(todo);
	}

}
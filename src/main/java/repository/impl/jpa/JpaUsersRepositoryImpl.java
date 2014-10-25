package repository.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.ToDo;
import model.Users;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import repository.interfaces.UsersRepository;
import enums.Continent;
import enums.Type;

/**
 * @author antoan
 */
@Repository
public class JpaUsersRepositoryImpl implements UsersRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Users findById(int id) throws DataAccessException {
		Query query = (Query) entityManager.createQuery("SELECT u FROM users u WHERE u.user_id =:user_id");
		query.setParameter(id, "user_id");
		return (Users) query.getSingleResult();
	}

	public Users findByName(String name) throws DataAccessException {
		Query query = entityManager.createQuery("SELECT u FROM users u WHERE users.name LIKE :name");
		query.setParameter(name, "name");
		return (Users) query.getResultList();
	}

	public void save(Users user) {
		entityManager.persist(user);
	}

	public ToDo listAllUsers() {
		Query query = entityManager.createQuery("SELECT u FROM users u");
		return (ToDo) query.getResultList();
	}

	public void delete(int id) {
		Query query = entityManager.createQuery("DELETE FROM users u WHERE u.user_id =:user_id");
		query.setParameter(id, "user_id");
		entityManager.flush();
	}

	public void update(Users user) {
		entityManager.merge(user);
	}

	public void create(int id, String name, Type type, Continent continent, String country, String userName, String password) {
		
		Users user = new Users();
		user.setUser_id(id);
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);
		user.setContinent(continent);
		user.setCountry(country);
		user.setType(type);
		
		entityManager.persist(user);
	}

}
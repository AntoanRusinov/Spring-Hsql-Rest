package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import enums.Continent;
import enums.Type;

/**
 * @author antoan
 */
@Entity
@Table(name = "users")
@Component
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer user_id;

	@Column(name = "name")
	private String name;

	@Column(name = "typee")
	private Type type;

	@Column(name = "continent")
	private Continent continent;

	@Column(name = "country")
	private String country;

	@Column(name = "user_name")
	private String userName;

	private String password;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
	private Set<ToDo> toDoSet;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
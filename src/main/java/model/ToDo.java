package model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author antoan
 */

@Entity
@Table(name = "to_do")
@Component
public class ToDo {

	@Id
	@GeneratedValue
	@Column(name = "to_do_id")
	private Integer to_do_id;

	@Column(name = "content")
	private String content;

	@Column(name = "last_modified_date")
	private Timestamp lastModifiedDate;

	@JoinColumn(name="user_id")
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	Users user;

	public Integer getTo_do_id() {
		return to_do_id;
	}

	public void setTo_do_id(Integer to_do_id) {
		this.to_do_id = to_do_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}

package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@Table(name="log")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp created;

	@Lob
	private String data;

	public Log() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
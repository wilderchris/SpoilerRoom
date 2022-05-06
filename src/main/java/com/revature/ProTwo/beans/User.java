package com.revature.ProTwo.beans;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="p_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	@Column(name="passwd")
	private String password;
	
	@ManyToOne()
	@JoinColumn(name="rank_id") // name of the fk
	private UserRank rank;

	
	public User() {
		id = 0;
		firstName = "first";
		lastName = "last";
		username= "username";
		password= "password";
		rank= new UserRank();
	}

	public User(int id) {
		super();
		this.id = id;
	}
	public User(String username) {//?
		super();
		this.username = username;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRank getRank() {
		return rank;
	}

	public void setRank(UserRank rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, password, rank, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && rank == other.rank && id == other.id
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", rankId=" + rank + "]";
	}


}

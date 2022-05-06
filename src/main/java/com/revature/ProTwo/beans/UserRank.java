package com.revature.ProTwo.beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_rank")
public class UserRank {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rankTitle;

	public UserRank() {
		id = 1;
		rankTitle = "User";
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRankTitle() {
		return rankTitle;
	}

	public void setRankTitle(String rankTitle) {
		this.rankTitle = rankTitle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rankTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRank other = (UserRank) obj;
		return id == other.id && Objects.equals(rankTitle, other.rankTitle);
	}

	@Override
	public String toString() {
		return "UserRank [id=" + id + ", rankTitle=" + rankTitle + "]";
	}


}

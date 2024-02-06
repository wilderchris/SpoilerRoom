package com.revature.ProTwo.beans;

import java.util.Objects;

public class Genre {

		private int id = 0;
		private String name = "";
		
		
		public Genre() {
		this.id = 0;
		this.name = "NA";
		}


		public Genre(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		@Override
		public int hashCode() {
			return Objects.hash(id, name);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Genre other = (Genre) obj;
			return id == other.id && Objects.equals(name, other.name);
		}


		@Override
		public String toString() {
			return "Genre [id=" + id + ", name=" + name + "]";
		}
		
		
		
		
		
		
}

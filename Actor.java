package com.spring.boot.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actors")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "last_name", nullable = false, length = 255)
	private int yearOfBirth;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "actors_to_movies", joinColumns = {
			@JoinColumn(name = "actor_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "movie_id", referencedColumnName = "id") })
	private List<Movie> movies = new ArrayList<Movie>();

	private String last_name;

	private int year_of_birth;

	public Actor() {
		super();

	}

	public Actor(long id, String name, String last_name, int year_of_birth, List<Movie> movies) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.year_of_birth = year_of_birth;
		this.movies = movies;
	}

	public Actor(String name, String last_name, int year_of_birth, List<Movie> movies) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.year_of_birth = year_of_birth;
		this.movies = movies;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getYear_of_birth() {
		return year_of_birth;
	}

	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "\n Actor [id=" + id + ", name=" + name + ", last_name=" + last_name + ", year_of_birth=" + year_of_birth
				+ ", movies=" + movies + "]";
	}

}

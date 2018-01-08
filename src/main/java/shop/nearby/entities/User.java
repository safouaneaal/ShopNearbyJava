package shop.nearby.entities;


import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Document
public class User implements Serializable {
	@Id
    private String id;
	private String name;
	private String email;
	private String password;
	@Field("Location")
    private Location Location;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String email, String password, @Value("#root.Location")Location location) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		Location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Location getLocation() {
		return Location;
	}

	public void setLocation(Location location) {
		Location = location;
	}

	


	
}
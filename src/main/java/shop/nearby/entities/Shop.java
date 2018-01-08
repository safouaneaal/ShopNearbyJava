package shop.nearby.entities;

import java.io.Serializable;
import java.util.List;


//import javax.persistence.Embedded;
//import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection="shops")	
public class Shop implements Serializable{
	   @Id
       private String id;
	   private String name;
	   private String email;
	   private String picture;
	   private String city;
	   @Field
	   private Location location;
	   @DBRef(lazy = true)
	   private List<User> users;
	   
	   public Shop() {
		   
	   }
	    
	   public Shop(String name, String email, String picture, String city,
			Location location) {
		super();
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.city = city;
		this.location = location;
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


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}

	   
}
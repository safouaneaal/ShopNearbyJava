package shop.nearby.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//Usershop is a Shop liked or disliked by a specific user stored in database
@Document
public class UserShop implements Serializable{
	@Id
	private String id;
	private String iduser;
	private String idshop;
	@Field("status")
	private boolean Status; //Status true = like / false = disliked
	@Field("statusDate")
	private Date statusDate;
	
	public UserShop() {	}
	
	public UserShop(String id, String iduser, String idshop, @Value("#root.status") boolean status,  @Value("#root.statusDate")Date statusDate) {
		this.id = id;
		this.iduser = iduser;
		this.idshop = idshop;
		this.Status = status;
		this.statusDate = statusDate;
	}

	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getIdshop() {
		return idshop;
	}
	public void setIdshop(String idshop) {
		this.idshop = idshop;
	}
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	
	
	

}

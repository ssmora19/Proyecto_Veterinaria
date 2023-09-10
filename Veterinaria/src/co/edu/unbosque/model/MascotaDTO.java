package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class MascotaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String petname;
	private String race;
	private String ownername;
	private long id;
	private long ownerphone;
	//private Date petage;
	
	public MascotaDTO() {
	}

	public MascotaDTO(String petname, String race, String ownername,long id, long ownerphone) {
		super();
		this.petname = petname;
		this.race = race;
		this.ownername = ownername;
		this.id = id;
		this.ownerphone = ownerphone;
		//this.petage = petage;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOwnerphone() {
		return ownerphone;
	}

	public void setOwnerphone(long ownerphone) {
		this.ownerphone = ownerphone;
	}
	
	

//	public Date getPetage() {
//		return petage;
//	}
//
//	public void setPetage(Date petage) {
//		this.petage = petage;
//	}


	@Override
	public String toString() {
		return "MascotaDTO [petname=" + petname + ", race=" + race + ", ownername=" + ownername + ", id=" + id
				+ ", ownerphone=" + ownerphone +"]";
	}
	
	

}

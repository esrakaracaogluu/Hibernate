package com.esra.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OGRETMEN")
public class Ogretmen {
	
    @Id
    @Column(name="id")
    @SequenceGenerator(name="ogretmen_seq",sequenceName="SEQ_OGRETMEN",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ogretmen_seq")//De�erini sequenceden al�cam sequence de budur.
	
	private int id;
    
   // @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @OneToOne(cascade=CascadeType.ALL)
   // @OneToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="ogretmendetay_id")
    private OgretmenDetay ogretmenDetay;
    
    @Column(name="first_name")
	private String firstName;
    
    @Column(name="last_name")
	private String lastName;
    
    @Column(name="email")
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ogretmen(OgretmenDetay ogretmenDetay, String firstName, String lastName, String email) {
		super();
		this.ogretmenDetay = ogretmenDetay;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Ogretmen() {
		super();
	}
	
}

package com.esra.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KURS")
public class Kurs {

	@Id
	@Column(name = "Id")
	@SequenceGenerator(name = "kurs_seq", sequenceName = "SEQ_KURS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_seq") 
	private int id;

	@Column(name = "kurs_adý")
	private String kursAdi;

	@Column(name = "saat")
	private Integer saat;

	@ManyToOne
	@JoinColumn(name = "ogretmen_id")
	private Ogretmen ogretmen;
	//bu kursun n tane konusu var diyoruz aþaðýdaki satýr ile,bu kursun many kursu var
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//kurs one many olarak konulara ulaþýyoruz
	@JoinColumn(name = "kurs_id")//hangi kolonlar uzerinde iþlem yapýcaz
	//kurs tablosundaki konular listesi konu tablosuna gittiðimizde kurs_id'si üzerinden getir
	private List<Konu> konular;

	public void addKonu(Konu konu) {
		if(konular==null) {
			konular = new ArrayList<Konu>();
		}
		konular.add(konu);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKursAdi() {
		return kursAdi;
	}

	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}

	public Integer getSaat() {
		return saat;
	}

	public void setSaat(Integer saat) {
		this.saat = saat;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public List<Konu> getKonular() {
		return konular;
	}

	public void setKonular(List<Konu> konular) {
		this.konular = konular;
	}

	public Kurs(String kursAdi, Integer saat, Ogretmen ogretmen) {
		super();
		this.kursAdi = kursAdi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}

	public Kurs() {
		super();
	}

	@Override
	public String toString() {
		return  kursAdi ;
	}

}

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name = "ogrenci_kurs", joinColumns=@JoinColumn(name="kurs_id"),
	                   inverseJoinColumns = @JoinColumn(name = "ogrenci_id"))
	private List<Ogrenci> ogrenciler;//Bu kursun öðrencileri

	@ManyToOne
	@JoinColumn(name = "ogretmen_id")
	private Ogretmen ogretmen;
	
	public void addOgrenci(Ogrenci o) {
		if(ogrenciler==null)
			ogrenciler=new ArrayList<Ogrenci>();
		
		ogrenciler.add(o);//Burasý ile gelen öðrenciyi kursa ekliyoruz.
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

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
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
		return kursAdi;
	}

}

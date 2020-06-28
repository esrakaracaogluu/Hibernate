package com.esra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KONU")
public class Konu {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "konu_seq", sequenceName = "KONU_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "konu_seq")
	private int id;

	@Column(name = "konu_baslýgý")
	private String konuBasligi;

	@Column(name = "konu_detayý")
	private String konuDetay;

	// private Kurs kurs;// elimizde kurs_id diye bir þey var burdan ona referans
	// yapýyoruz

	public Konu(String konuBasligi, String konuDetay) {
		super();
		this.konuBasligi = konuBasligi;
		this.konuDetay = konuDetay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKonuBasligi() {
		return konuBasligi;
	}

	public void setKonuBasligi(String konuBasligi) {
		this.konuBasligi = konuBasligi;
	}

	public String getKonuDetay() {
		return konuDetay;
	}

	public void setKonuDetay(String konuDetay) {
		this.konuDetay = konuDetay;
	}

	public Konu() {
		super();
	}

	@Override
	public String toString() {
		return "Konu: " + konuBasligi ;
	}

	
}

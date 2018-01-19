package com.mest.hibernate.app.entity;

// default package
// Generated 2018-01-19 22:38:11 by Hibernate Tools 5.2.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Kasa generated by hbm2java
 */
public class Kasa implements java.io.Serializable {

	private Integer idZakupu;
	private Pracownik pracownik;
	private Date data;
	private Set<Zakup> zakups = new HashSet<Zakup>(0);

	public Kasa() {
	}

	public Kasa(Pracownik pracownik, Date data) {
		this.pracownik = pracownik;
		this.data = data;
	}

	public Kasa(Pracownik pracownik, Date data, Set<Zakup> zakups) {
		this.pracownik = pracownik;
		this.data = data;
		this.zakups = zakups;
	}

	public Integer getIdZakupu() {
		return this.idZakupu;
	}

	public void setIdZakupu(Integer idZakupu) {
		this.idZakupu = idZakupu;
	}

	public Pracownik getPracownik() {
		return this.pracownik;
	}

	public void setPracownik(Pracownik pracownik) {
		this.pracownik = pracownik;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<Zakup> getZakups() {
		return this.zakups;
	}

	public void setZakups(Set<Zakup> zakups) {
		this.zakups = zakups;
	}

}

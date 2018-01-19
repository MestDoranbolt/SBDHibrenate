package com.mest.hibernate.app.entity;

// default package
// Generated 2018-01-19 22:38:11 by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Zwierze generated by hbm2java
 */
public class Zwierze implements java.io.Serializable {

	private Integer idZwierzecia;
	private String gatunek;
	private String plec;
	private String imie;
	private int potomstwo;
	private Set<Wybieg> wybiegs = new HashSet<Wybieg>(0);
	private Set<Pracownik> pracowniks = new HashSet<Pracownik>(0);

	public Zwierze() {
	}

	public Zwierze(String gatunek, String plec, String imie, int potomstwo) {
		this.gatunek = gatunek;
		this.plec = plec;
		this.imie = imie;
		this.potomstwo = potomstwo;
	}

	public Zwierze(String gatunek, String plec, String imie, int potomstwo, Set<Wybieg> wybiegs,
			Set<Pracownik> pracowniks) {
		this.gatunek = gatunek;
		this.plec = plec;
		this.imie = imie;
		this.potomstwo = potomstwo;
		this.wybiegs = wybiegs;
		this.pracowniks = pracowniks;
	}

	public Integer getIdZwierzecia() {
		return this.idZwierzecia;
	}

	public void setIdZwierzecia(Integer idZwierzecia) {
		this.idZwierzecia = idZwierzecia;
	}

	public String getGatunek() {
		return this.gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}

	public String getPlec() {
		return this.plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public int getPotomstwo() {
		return this.potomstwo;
	}

	public void setPotomstwo(int potomstwo) {
		this.potomstwo = potomstwo;
	}

	public Set<Wybieg> getWybiegs() {
		return this.wybiegs;
	}

	public void setWybiegs(Set<Wybieg> wybiegs) {
		this.wybiegs = wybiegs;
	}

	public Set<Pracownik> getPracowniks() {
		return this.pracowniks;
	}

	public void setPracowniks(Set<Pracownik> pracowniks) {
		this.pracowniks = pracowniks;
	}

}
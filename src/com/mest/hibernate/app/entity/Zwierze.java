package com.mest.hibernate.app.entity;

// default package
// Generated 2018-01-20 16:46:25 by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Zwierze generated by hbm2java
 */
@Entity
@Table(name = "ZWIERZE", catalog = "ministrant_SBD")
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

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_zwierzecia", unique = true, nullable = false)
	public Integer getIdZwierzecia() {
		return this.idZwierzecia;
	}

	public void setIdZwierzecia(Integer idZwierzecia) {
		this.idZwierzecia = idZwierzecia;
	}

	@Column(name = "gatunek", nullable = false, length = 20)
	public String getGatunek() {
		return this.gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}

	@Column(name = "plec", nullable = false, length = 6)
	public String getPlec() {
		return this.plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	@Column(name = "imie", nullable = false, length = 20)
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@Column(name = "potomstwo", nullable = false)
	public int getPotomstwo() {
		return this.potomstwo;
	}

	public void setPotomstwo(int potomstwo) {
		this.potomstwo = potomstwo;
	}

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "ZAKWATEROWANIE", catalog = "ministrant_SBD", joinColumns = {
			@JoinColumn(name = "id_zwierzecia", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_wybiegu", nullable = false, updatable = false) })
	public Set<Wybieg> getWybiegs() {
		return this.wybiegs;
	}

	public void setWybiegs(Set<Wybieg> wybiegs) {
		this.wybiegs = wybiegs;
	}

	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "zwierzes")
	public Set<Pracownik> getPracowniks() {
		return this.pracowniks;
	}

	public void setPracowniks(Set<Pracownik> pracowniks) {
		this.pracowniks = pracowniks;
	}

	@Override
	public String toString() {
		return "Zwierze [idZwierzecia=" + idZwierzecia + ", gatunek=" + gatunek + ", plec=" + plec + ", imie=" + imie
				+ ", potomstwo=" + potomstwo + "]";
	}
	
	

}

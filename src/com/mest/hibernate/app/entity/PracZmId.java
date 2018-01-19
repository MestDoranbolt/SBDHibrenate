package com.mest.hibernate.app.entity;

// default package
// Generated 2018-01-19 22:38:11 by Hibernate Tools 5.2.6.Final

/**
 * PracZmId generated by hbm2java
 */
public class PracZmId implements java.io.Serializable {

	private int idPracownika;
	private int idZmiany;

	public PracZmId() {
	}

	public PracZmId(int idPracownika, int idZmiany) {
		this.idPracownika = idPracownika;
		this.idZmiany = idZmiany;
	}

	public int getIdPracownika() {
		return this.idPracownika;
	}

	public void setIdPracownika(int idPracownika) {
		this.idPracownika = idPracownika;
	}

	public int getIdZmiany() {
		return this.idZmiany;
	}

	public void setIdZmiany(int idZmiany) {
		this.idZmiany = idZmiany;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PracZmId))
			return false;
		PracZmId castOther = (PracZmId) other;

		return (this.getIdPracownika() == castOther.getIdPracownika())
				&& (this.getIdZmiany() == castOther.getIdZmiany());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdPracownika();
		result = 37 * result + this.getIdZmiany();
		return result;
	}

}

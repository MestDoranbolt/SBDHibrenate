package com.mest.hibernate.app.entity;

// default package
// Generated 2018-01-20 16:46:25 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ZakupId generated by hbm2java
 */
@Embeddable
public class ZakupId implements java.io.Serializable {

	private int idZakupu;
	private int idProduktu;

	public ZakupId() {
	}

	public ZakupId(int idZakupu, int idProduktu) {
		this.idZakupu = idZakupu;
		this.idProduktu = idProduktu;
	}

	@Column(name = "id_zakupu", nullable = false)
	public int getIdZakupu() {
		return this.idZakupu;
	}

	public void setIdZakupu(int idZakupu) {
		this.idZakupu = idZakupu;
	}

	@Column(name = "id_produktu", nullable = false)
	public int getIdProduktu() {
		return this.idProduktu;
	}

	public void setIdProduktu(int idProduktu) {
		this.idProduktu = idProduktu;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ZakupId))
			return false;
		ZakupId castOther = (ZakupId) other;

		return (this.getIdZakupu() == castOther.getIdZakupu()) && (this.getIdProduktu() == castOther.getIdProduktu());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdZakupu();
		result = 37 * result + this.getIdProduktu();
		return result;
	}

}

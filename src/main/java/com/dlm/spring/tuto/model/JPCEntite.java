package com.dlm.spring.tuto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jpc_entites")
public class JPCEntite {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dkey")
	private int dkey;
	
	@Column(name = "entite")
	private String entite;
	
	public JPCEntite() {
    }

    public JPCEntite(int dkey, String entite) {
        this.dkey = dkey;
        this.entite = entite;
    }

	public int getDkey() {
		return dkey;
	}

	public void setDkey(int dkey) {
		this.dkey = dkey;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}
	
	
	
}

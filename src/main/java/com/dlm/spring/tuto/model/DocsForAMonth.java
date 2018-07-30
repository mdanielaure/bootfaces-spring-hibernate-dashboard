package com.dlm.spring.tuto.model;


public class DocsForAMonth {

	public String mois;
	public String nbDoc;
	public String source;
	
	

	public DocsForAMonth(){
		
	}
	
	public DocsForAMonth(String mois, String nbDoc){
		this.mois=mois;
		this.nbDoc=nbDoc;
	}
	
	public DocsForAMonth(String mois, String nbDoc, String source){
		this.mois=mois;
		this.nbDoc=nbDoc;
		this.source= source;
	}
	
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public String getNbDoc() {
		return nbDoc;
	}
	public void setNbDoc(String nbDoc) {
		this.nbDoc = nbDoc;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	
}

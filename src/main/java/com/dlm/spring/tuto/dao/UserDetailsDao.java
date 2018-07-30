package com.dlm.spring.tuto.dao;

import java.util.List;

import com.dlm.spring.tuto.model.DocsForAMonth;
import com.dlm.spring.tuto.model.JPCEntite;

public interface UserDetailsDao {
    
    public void addEntite(JPCEntite entite);
    public List<DocsForAMonth> docByMonthForASource(int year, String canal);
	public List<DocsForAMonth> docByMonthBySource(int year);

}

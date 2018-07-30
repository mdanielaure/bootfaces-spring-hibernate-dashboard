package com.dlm.spring.tuto.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dlm.spring.tuto.dao.UserDetailsDao;
import com.dlm.spring.tuto.model.DocsForAMonth;
import com.dlm.spring.tuto.model.JPCEntite;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    @Transactional
	@Override
	public void addEntite(JPCEntite entite) {
		getSessionFactory().getCurrentSession().save(entite);
		
	}
    
    @Transactional
	@Override
	public List<DocsForAMonth> docByMonthForASource(int year, String canal) {
		String hql ="";
		if(canal==null){
			hql = "select month(date_creation) as mois, count(dkey) as keys from documents where year(date_creation)="+year+" and source is null group by month(date_creation)";
		}
		else{
			hql = "select month(date_creation) as mois, count(dkey) as keys from documents where year(date_creation)="+year+" and source='"+canal+"' group by month(date_creation)";
		}
		List<DocsForAMonth> lst = new ArrayList<DocsForAMonth>();
		List<Object[]> listResult = getSessionFactory().getCurrentSession().createSQLQuery(hql).list();
			
		for(Object[] aRow : listResult){
    		lst.add(new DocsForAMonth(String.valueOf(aRow[0]),String.valueOf(aRow[1])));
    	}	
		
		return lst;
	}
    
    @Transactional
	@Override
	public List<DocsForAMonth> docByMonthBySource(int year) {
    	String hql ="";
		hql = "select month(date_creation) as mois, count(dkey) as keys, source as source from documents where year(date_creation)="+year+" group by month(date_creation), source order by source,month(date_creation)";
		List<DocsForAMonth> lst = new ArrayList<DocsForAMonth>();
		List<Object[]> listResult = getSessionFactory().getCurrentSession().createSQLQuery(hql).list();
			
		for(Object[] aRow : listResult){
    		lst.add(new DocsForAMonth(String.valueOf(aRow[0]),String.valueOf(aRow[1]),String.valueOf(aRow[2])));
    	}	
		
		return lst;
	}

}

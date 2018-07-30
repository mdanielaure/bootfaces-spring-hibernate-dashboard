package com.dlm.spring.tuto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlm.spring.tuto.dao.UserDetailsDao;
import com.dlm.spring.tuto.model.DocsForAMonth;
import com.dlm.spring.tuto.model.JPCEntite;
import com.dlm.spring.tuto.service.UserDetailsService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;


    public UserDetailsDao getUserDetailsDao() {
        return userDetailsDao;
    }

	
	@Transactional(readOnly = false)
	@Override
	public void addEntite(JPCEntite enti) {
		getUserDetailsDao().addEntite(enti);
		
		
	}
	
	@Transactional
	@Override
	public List<DocsForAMonth> docByMonthForASource(int year, String canal) {
		
		return getUserDetailsDao().docByMonthForASource(year, canal);
	}
	
	@Transactional
	@Override
	public List<DocsForAMonth> docByMonthBySource(int year) {
		
		return getUserDetailsDao().docByMonthBySource(year);
	}

}

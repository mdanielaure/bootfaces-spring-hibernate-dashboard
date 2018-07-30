package com.dlm.spring.tuto.managerBean;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.dlm.spring.tuto.model.JPCEntite;
import com.dlm.spring.tuto.service.UserDetailsService;

@ManagedBean(name="userDetailsMBean")
@SessionScoped
public class UserDetailsMBean implements Serializable {

	private static final long serialVersionUID = 1L;

    //inject spring bean via DI
	@ManagedProperty(value="#{userDetailsService}")
	private UserDetailsService userDetailsService;


	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
    
	 
    private int dkey;
    private String entite;
    
    
   
    
//    @PostConstruct
//    public void init() {
//        createLineModels();
//    }
    
    public String addEntite(){
    	JPCEntite enti = new JPCEntite();
    	enti.setEntite(getEntite());
    	getUserDetailsService().addEntite(enti);
    	
    	return null;
    }
 

 
    

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public int getDkey() {
		return dkey;
	}

	public void setDkey(int dkey) {
		this.dkey = dkey;
	}

}

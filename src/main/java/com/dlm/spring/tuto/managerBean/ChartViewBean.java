package com.dlm.spring.tuto.managerBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.dlm.spring.tuto.model.DocsForAMonth;
import com.dlm.spring.tuto.model.JPCEntite;
import com.dlm.spring.tuto.service.UserDetailsService;


@ManagedBean(name="chartViewBean")
@SessionScoped
public class ChartViewBean implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//inject spring bean via DI
	@ManagedProperty(value="#{userDetailsService}")
	private UserDetailsService userDetailsService;
	 
	private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private BarChartModel lineModel3;
    
    private int dkey;
    private String entite;
    private int year = Calendar.getInstance().get(Calendar.YEAR);
    private int ymax = 0;
    
    private List<DocsForAMonth> docsResult;
    
    private List<DocsForAMonth>  sourcesList = new ArrayList<DocsForAMonth>();
    
   
    
   @PostConstruct
    public void init() {
	   sourcesList = getUserDetailsService().docByMonthBySource(getYear());
        createLineModels();
    }
    
   
   public void refreshChart(){
	   init();
//	   return null;
   }
   
    public String addEntite(){
    	JPCEntite enti = new JPCEntite();
    	enti.setEntite(getEntite());
    	getUserDetailsService().addEntite(enti);
    	
    	return null;
    }
 
 
    public List<DocsForAMonth> getDocsResult(int year, String canal) {
    	
		docsResult = getUserDetailsService().docByMonthForASource(year, canal);
			
		return docsResult;
	}

	public void setDocsResult(List<DocsForAMonth> docsResult) {
		this.docsResult = docsResult;
	}
	
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
    
    public BarChartModel getLineModel3() {
        return lineModel3;
    }
     
    private void createLineModels() {
    	
    	lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis(Integer.toString(getYear())));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
//        yAxis.setLabel(Integer.toString(getYear()));
        yAxis.setMin(0);
        if(getYmax()!=0){
        	yAxis.setMax(getYmax());
        }
         
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Category Chart");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis(Integer.toString(getYear())));
        yAxis = lineModel2.getAxis(AxisType.Y);
//        yAxis.setLabel(Integer.toString(getYear()));
        yAxis.setMin(0);
        if(getYmax()!=0){
        	yAxis.setMax(getYmax());
        }

        lineModel3 = initStatGedModel();
        lineModel3.setTitle("Stats documents en GED");
        lineModel3.setLegendPosition("e");
        lineModel3.setShowPointLabels(true);
        lineModel3.getAxes().put(AxisType.X, new CategoryAxis(Integer.toString(getYear())));
        yAxis = lineModel3.getAxis(AxisType.Y);
//        yAxis.setLabel(Integer.toString(getYear()));
        yAxis.setMin(0);
        if(getYmax()!=0){
        	yAxis.setMax(getYmax());
        }
    }
     
   
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries courrier = new ChartSeries();
        getChartSeries("Courrier", courrier);      
        	
		ChartSeries extranet = new ChartSeries();
		getChartSeries("Extranet", extranet);
	    
	      	
        ChartSeries picris = new ChartSeries();
        getChartSeries("Picris", picris);
	         	
      	
      	ChartSeries sirius = new ChartSeries();
      	getChartSeries("Sirius", sirius);
      	
      	ChartSeries fax = new ChartSeries();
      	getChartSeries("Fax", fax);
        
      	
      	ChartSeries email = new ChartSeries();
    	getChartSeries("Email", email);
      	
      	ChartSeries none = new ChartSeries();
      	getChartSeries("None", none);

        model.addSeries(courrier);
        model.addSeries(extranet);
        model.addSeries(picris);
        model.addSeries(sirius);
        model.addSeries(fax);
        model.addSeries(email);
        model.addSeries(none);
         
        return model;
    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries courrier = new ChartSeries();
        getChartSeries("Courrier", courrier);      
        	
		ChartSeries extranet = new ChartSeries();
		getChartSeries("Extranet", extranet);
	    
	      	
        ChartSeries picris = new ChartSeries();
        getChartSeries("Picris", picris);
	         	
      	
      	ChartSeries sirius = new ChartSeries();
      	getChartSeries("Sirius", sirius);
      	
      	ChartSeries fax = new ChartSeries();
      	getChartSeries("Fax", fax);
        
      	
      	ChartSeries email = new ChartSeries();
    	getChartSeries("Email", email);
      	
      	ChartSeries none = new ChartSeries();
      	getChartSeries("None", none);

        model.addSeries(courrier);
        model.addSeries(extranet);
        model.addSeries(picris);
        model.addSeries(sirius);
        model.addSeries(fax);
        model.addSeries(email);
        model.addSeries(none);
         
        return model;
    }
    
    private BarChartModel initStatGedModel() {
        BarChartModel model = new BarChartModel();
        
        ChartSeries courrier = new ChartSeries();
        getChartSeries("Courrier", courrier);      
        	
		ChartSeries extranet = new ChartSeries();
		getChartSeries("Extranet", extranet);
	    
	      	
        ChartSeries picris = new ChartSeries();
        getChartSeries("Picris", picris);
	         	
      	
      	ChartSeries sirius = new ChartSeries();
      	getChartSeries("Sirius", sirius);
      	
      	ChartSeries fax = new ChartSeries();
      	getChartSeries("Fax", fax);
        
      	
      	ChartSeries email = new ChartSeries();
    	getChartSeries("Email", email);
      	
      	ChartSeries none = new ChartSeries();
      	getChartSeries("None", none);

        model.addSeries(courrier);
        model.addSeries(extranet);
        model.addSeries(picris);
        model.addSeries(sirius);
        model.addSeries(fax);
        model.addSeries(email);
        model.addSeries(none);
        
         
        return model;
    }
    
    public void getChartSeries(String source, ChartSeries sery){
    	
        sery.setLabel(source);
        if("None".equals(source)){
        	source="null";
        }
    	 boolean found=false;
         for(int j=1; j<=12; j++){
         	found=false;
         	for(DocsForAMonth aRow : sourcesList){
         		if(Integer.parseInt(aRow.getMois())==j && source.equals(aRow.getSource())){
         			sery.set(j, Integer.parseInt(aRow.getNbDoc()));
         			found=true;
         			break;
         		}
         		else continue;
         		
         	}
         	
         	if(found==false){
         		sery.set(j, 0);
         	}
         }
    }
    
    public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	public UserDetailsService getUserDetailsService() {
        return userDetailsService;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	public List<DocsForAMonth> getSourcesList() {
		return sourcesList;
	}


	public void setSourcesList(List<DocsForAMonth> sourcesList) {
		this.sourcesList = sourcesList;
	}


	public int getYmax() {
		return ymax;
	}


	public void setYmax(int ymax) {
		this.ymax = ymax;
	}


	
	
 
}

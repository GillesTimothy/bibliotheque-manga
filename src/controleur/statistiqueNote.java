package controleur;
import java.sql.ResultSet;
import java.sql.Statement;

import modele.Connecter;
import vue.statistique;

public class statistiqueNote extends statistique {
	
	Connecter conn=new Connecter();
	Statement stm;
	ResultSet Rs;
	
	public statistiqueNote() {
		super();
		
		jLabel8.setText("nbr de manga en cours :");
		jLabel9.setText("nbr de manga terminer :");
		jLabel10.setText("nbr de tome :");
		
		
		try {
        	stm=conn.obtenirconnexion().createStatement();
        	ResultSet Rs=stm.executeQuery("select count(distinct Titre) from manga where Status like \"enCours\";");
        	while(Rs.next()) {
        		int value1 = Rs.getInt(1); 
        		jLabel11.setText(String.valueOf(value1));
        	}       	
        } catch(Exception e){
        	System.err.println(e);
        	} 
    
	    try {
	    	stm=conn.obtenirconnexion().createStatement();
	    	ResultSet Rs=stm.executeQuery("select count(distinct Titre) from manga where Status like \"terminer\";");
	    	while(Rs.next()) {
	    		int value2 = Rs.getInt(1); 
        		jLabel12.setText(String.valueOf(value2));	    			
	    	}  	
	    } catch(Exception e){
	    	System.err.println(e);
	    	} 
	    
	    try {
	    	stm=conn.obtenirconnexion().createStatement();
	    	ResultSet Rs=stm.executeQuery("select sum(NbrTome) from manga;");
	    	while(Rs.next()) {
	    		int value3 = Rs.getInt(1); 
        		jLabel13.setText(String.valueOf(value3));	    			
	    	}  	
	    } catch(Exception e){
	    	System.err.println(e);
	    	} 
	    
	}
	
	

}

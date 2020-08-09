import java.sql.ResultSet;
import java.sql.Statement;

public class statistiqueNote extends statistique {
	
	Connecter conn=new Connecter();
	Statement stm;
	ResultSet Rs;
	
	public statistiqueNote() {
		try {
        	stm=conn.obtenirconnexion().createStatement();
        	ResultSet Rs=stm.executeQuery("select count(distinct Titre) from manga where Status like \"enCours\";");
        	while(Rs.next()) {
        		int value1 = Rs.getInt(1); 
        		jLabel4.setText(String.valueOf(value1));
        	}       	
        } catch(Exception e){
        	System.err.println(e);
        	} 
    
	    try {
	    	stm=conn.obtenirconnexion().createStatement();
	    	ResultSet Rs=stm.executeQuery("select count(distinct Titre) from manga where Status like \"terminer\";");
	    	while(Rs.next()) {
	    		int value2 = Rs.getInt(1); 
        		jLabel5.setText(String.valueOf(value2));	    			
	    	}  	
	    } catch(Exception e){
	    	System.err.println(e);
	    	} 
	    
	    try {
	    	stm=conn.obtenirconnexion().createStatement();
	    	ResultSet Rs=stm.executeQuery("select sum(NbrTome) from manga;");
	    	while(Rs.next()) {
	    		int value3 = Rs.getInt(1); 
        		jLabel6.setText(String.valueOf(value3));	    			
	    	}  	
	    } catch(Exception e){
	    	System.err.println(e);
	    	} 
	    
	}
	
public static void main(String args[]) {
        
    	/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new statistiqueNote().setVisible(true);
                }
        });
    }

}

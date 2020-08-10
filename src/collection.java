

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class collection {
	
	ArrayList<Object> collec = new ArrayList<Object>();

	private static int id;
    private static String titre;
    private static String auteur;
    private static String status;
    private static int nbrTome;
    
    public collection(){
		
		this.id = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'id du manga"));
		this.titre = JOptionPane.showInputDialog("Entrez le titre du manga");
		this.auteur = JOptionPane.showInputDialog("Entrez l'auteur du manga");
		this.status = JOptionPane.showInputDialog("Entrez le status du manga");
		this.nbrTome = Integer.parseInt(JOptionPane.showInputDialog("Entrez le nombre de tome déjà lu du manga"));	
		
	}
    
    public void ajouter(Object object) {     
        collec.add(this.titre);
        collec.add(this.auteur);
        collec.add(this.status);
        collec.add(this.nbrTome);
    }
  
    public void affiche() {

		for(int i = 0; i < collec.size(); i++)
		    System.out.println(collec.get(i));
	}
    
    
    public static void main(String[] args) {
        
    	id = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'id du manga"));
		titre = JOptionPane.showInputDialog("Entrez le titre du manga");
		auteur = JOptionPane.showInputDialog("Entrez l'auteur du manga");
		status = JOptionPane.showInputDialog("Entrez le status du manga");
		nbrTome = Integer.parseInt(JOptionPane.showInputDialog("Entrez le nombre de tome déjà lu du manga"));
		
		
		ArrayList<ArrayList<Object>> collec=new ArrayList<>();
        ArrayList<Object> id=new ArrayList<Object>();
        id.add(titre);
        id.add(auteur);
        id.add(status);
        id.add(nbrTome);
        collec.add(0,id);
     
        for(ArrayList p:collec) {
            for(int i=0;i<collec.size();i++)
		        System.out.println("["+collec.indexOf(p)+"] " + p.get(0) +" "+ p.get(1) + " " + p.get(2) + " " + p.get(3) ); 
		}
    	
        
      }
    
   
    public collection(int id, String titre, String auteur, String status, int nbrTome) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.status = status;
		this.nbrTome = nbrTome;
	} 
    
    public String getTitre() {
		return titre;
	}

    public void setTitre(String titre) {
		this.titre = titre;
	}

    public String getAuteur() {
		return auteur;
	}

    public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

    public String getStatus() {
		return status;
	}

    public void setStatus(String status) {
		this.status = status;
	}

    public int getNbrTome() {
		return nbrTome;
	}

    public void setNbrTome(int nbrTome) {
		this.nbrTome = nbrTome;
	}  
	
    
    @Override
    public String toString() {
		return "id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", status=" + status
				+ ", nbrTome=" + nbrTome;
	}
    

}

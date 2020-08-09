package controleur;

import java.awt.HeadlessException;

public class collection {

	private String id;
    private String titre;
    private String auteur;
    private String status;
    private String nbrTome;
    
    public collection(String id, String titre, String auteur, String status, String nbrTome)
			throws HeadlessException {
		super();
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

    public String getNbrTome() {
		return nbrTome;
	}

    public void setNbrTome(String nbrTome) {
		this.nbrTome = nbrTome;
	}
	
    @Override
    public String toString() {
		return "controleurCollection [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", status=" + status
				+ ", nbrTome=" + nbrTome + "]";
	}
    

}

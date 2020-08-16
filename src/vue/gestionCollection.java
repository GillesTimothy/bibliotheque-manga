package vue;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controleur.statistiqueNote;
import modele.Connecter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;

/**
 * <b> gestionCollection est la classe qui permet de g�rer la collection de manga sur l'application </b>
 * <p>
 * Un manga de la collection est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un id unique</li>
 * <li>Un titre unique</li>
 * <li>Un auteur</li>
 * <li>Un status, il peut �tre encours ou terminer</li>
 * <li>Un nombre de tomes</li>
 * </ul> 
 * <p>
 * Un manga peu �tre ajoute� � la collection
 * </p>
 * <p>
 * Un manga peu �tre supprim� de la collection
 * </p>
 * <p>
 * Un manga peu �tre modifi� dans la collection
 * </p>
 * 
 * @see jButton1ActionPerformed(java.awt.event.ActionEvent evt)
 * @see jButton2ActionPerformed(java.awt.event.ActionEvent evt)
 * @see jButton5ActionPerformed(java.awt.event.ActionEvent evt)
 * 
 * @author gilles
 *
 */
public class gestionCollection extends javax.swing.JFrame {

	
	Connecter conn=new Connecter();
	Statement stm;
	ResultSet Rs;
	/**
	 * Table pour l'affichage de la collection
	 */
	DefaultTableModel model=new DefaultTableModel();

// Variables declaration
	/**
	 * L'id d'un manga de la collection
	 */
	private String id;
	/**
	 * Le titre d'un manga de la collection
	 */
    private String titre;
    /**
     * L'auteur d'un manga de la collection
     */
    private String auteur;
    /**
     * Le status d'un manga de la collection
     */
    private String status;
    /**
     * Le nombre de tome d'un manga de la collection
     */
    private String nbrTome;
    
 // Variables interface declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tble;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox txtStatus;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtTitre;
    private javax.swing.JTextField txtNbrTome;
    private javax.swing.JTextField txtAuteur;
    private javax.swing.JTextField txtRech;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox txtRech2;
    
    /**
     * 
     */
    public gestionCollection() {
    	  	
        initComponents();
        
        model.addColumn("id");
        model.addColumn("Titre");
        model.addColumn("Auteur");
        model.addColumn("Status");
        model.addColumn("NbrTome");
        try {
        	stm=conn.obtenirconnexion().createStatement();
        	ResultSet Rs=stm.executeQuery("Select * from manga");
        	while(Rs.next()) {
        		model.addRow(new Object[] {Rs.getString("id"),Rs.getString("Titre"),Rs.getString("Auteur"),
        				Rs.getString("Status"),Rs.getString("NbrTome")});	
        	}
        } catch(Exception e){
        	System.err.println(e);
        	}
        tble.setModel(model);
    }    
    
    /**
     * D�place les valeurs pr�sentent dans le model vers les diff�rents champs de texte 
     * (txtid, txtTitre, txtAuteur, txtStatus, txtNbrTome)
     * @param i position sur la tableModel
     */
    private void deplace(int i) {
    	try {
    		txtid.setText(model.getValueAt (i, 0).toString());
    		txtTitre.setText(model.getValueAt (i, 1).toString());
    		txtAuteur.setText(model.getValueAt (i, 2).toString());
    		txtStatus.setSelectedItem(model.getValueAt (i, 3).toString());
    		txtNbrTome.setText(model.getValueAt (i, 4).toString());

    	}catch (Exception e){
    		System.err.println(e);
    		JOptionPane.showMessageDialog(null , "erreur de d�placement"+e.getLocalizedMessage());
    	}
    }
    
    /**
     * Affiche les valeurs de la base de donn�es "manga" dans la table model.
     */
    private void affiche() {
    	try {
    		model.setRowCount(0);
        	stm=conn.obtenirconnexion().createStatement();
        	ResultSet Rs=stm.executeQuery("Select * from manga");
        	while(Rs.next()) {
        		model.addRow(new Object[] {Rs.getString("id"),Rs.getString("Titre"),Rs.getString("Auteur"),
        				Rs.getString("Status"),Rs.getString("NbrTome")});	
        	}
        } catch(Exception e){
        	System.err.println(e);
        	}
        tble.setModel(model);
    }
    
    //affiche valeurs quand on clique dans le tableau.
    /**
     * R�cup�re la position dans la table tble et joue la methode deplace(i)
     * @param evt clique sur une case de la table
     * @see deplace(i)
     */
    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {
    	try{
    		int i=tble.getSelectedRow();
    		deplace(i);
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null,"erreur de deplacement "+e.getLocalizedMessage());}
    		}
    
    
    //bouton AJOUTER
    /**
     * Recup�re les valeurs des champs txtid txtTitre txtAuteur txtStatus txtNbrTome
     * pour les ajouter a la base de donn�es
     * @param evt clique sur le bouton ajouter
     * @exception les valeur des champs txtid ou txtTtre sont d�j� pr�sente dans la base de donn�es.
     * @see affiche()
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        id=txtid.getText();
        titre=txtTitre.getText();
        auteur=txtAuteur.getText();
        status=txtStatus.getSelectedItem().toString();
        nbrTome=txtNbrTome.getText();
        String requete="insert into manga(id,Titre,Auteur,Status,NbrTome)VALUES('"+
                id+"','"+titre+"','"+auteur+"','"+status+"','"+nbrTome+"')";
        try{
        	stm.executeUpdate(requete);
        	JOptionPane.showMessageDialog(null,"Le manga a bien �t� ajouter � la collection");
        	txtid.setText(id);
        	txtTitre.setText("");
        	txtAuteur.setText("");
        	txtStatus.setSelectedItem(0);
        	txtNbrTome.setText("");
        	affiche();
        }catch(Exception ex){
        	JOptionPane.showMessageDialog(null,"l'id ou le manga "
        			+ "est d�j� dans la collection !!!"); //+ex.getMessage()
        	}
    }
    
    
    //bouton ACTUALISER
    /**
     * Affiche les valeurs de la base de donn�es "manga" dans la table model.
     * @param evt clique sur le bouton actualiser
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    	affiche();
    }
    
    
    //bouton MODIFIER
    /**
     * <p>
     * Modifier les valeurs d'un manga dans la base de donn�es
     * </p>
     * <p>
     * Affiche la table des manga reactualiser
     * </p>
     * @param evt clique sur le bouton modifier
     * @see affiche()
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    	try { 
    	            if (JOptionPane.showConfirmDialog (null,"confirmer la modification","modification",
    	                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

    	                stm.executeUpdate("UPDATE manga SET Titre='"+txtTitre.getText()+
    	                		"',Auteur='"+txtAuteur.getText()+
    	                		"',NbrTome='"+txtNbrTome.getText()+
    	                        "',Status='"+txtStatus.getSelectedItem().toString()+
    	                        "' WHERE id= "+txtid.getText());   
    	                affiche();
    	            } 
    	        } catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de modification !!!"+
    	            e.getMessage());
    	        System.err.println(e);}
    	    }
    
    
    //bouton SUPPRIMER
    /**
     * <p>
     * Supprime les valeurs d'un manga dans la base de donn�es
     * </p>
     * <p>
     * Affiche la table des manga reactualiser
     * </p>
     * @param evt clique sur le bouton supprimer
     * @see affiche()
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	            if(JOptionPane.showConfirmDialog(null,"voulez vous vraiment supprimer "
    	            		+ "ce manga de votre collection ?"
    	                     ,"supprimer manga",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
    	            if(txtid.getText().length() != 0){
    	        stm.executeUpdate("Delete From manga where id = "+txtid.getText());
    	        affiche();
    	             }
    	            else { JOptionPane.showMessageDialog(null,"veuillez SVP remplire le champ id !");}
    	        
    	        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur"
    	        		+ " de suppression \n"+e.getMessage());} 
    	    }
    
    
    //bouton STATISTIQUE
    /**
     * Creation d'un nouvel objet statistiqueNote
     * @param evt clique sur le bouton statistique
     */
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {
    	statistiqueNote a=new statistiqueNote();
    	a.setVisible(true);
    }
    
    
    //bouton RECHERCHE MANGA
    /**
     * Affiche le manga qui correspond au nom introduit dans le champ txtRech,
     * ainsi que toute les valeurs qui sont associ�es � ce manga
     * @param evt clique sur le bouton recherche manga
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	           model.setRowCount(0);// pour vider la list des mangas
    	      {	
    	       Rs = stm.executeQuery("Select * From manga WHERE Titre = '"+txtRech.getText()+"'");
    	       }while (Rs.next()){
    	       
    	       Object [] manga ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getString(5)};
    	     model.addRow(manga);
    	       } if (model.getRowCount () == 0){JOptionPane.showMessageDialog(null,"Aucun manga ne"
    	       		+ " correspond a ce titre dans la collection !");
    	       
    	       } else{ int i=0;
    	       deplace(i);
    	       }
    	       
    	       }catch (Exception e) { System.err.println(e);
    	       JOptionPane.showMessageDialog(null,e.getMessage());
       }
    	    
    }
    
  //bouton RECHERCHE AUTEUR
    /**
     * Affiche le/les manga qui correspond � l'auteur introduit dans le champ txtRech,
     * ainsi que toute les valeurs qui sont associ�es � ce/ces manga
     * @param evt clique sur le bouton recherche auteur
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	           model.setRowCount(0);// pour vider la list des mangas
    	      {
    	       Rs = stm.executeQuery("Select * From manga WHERE Auteur = '"+txtRech.getText()+"'");
    	       }while (Rs.next()){
    	       
    	       Object [] manga ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getString(5)};
    	     model.addRow(manga);
    	       } if (model.getRowCount () == 0){JOptionPane.showMessageDialog(null,"Aucun manga ne"
    	       		+ " correspond a cet auteur dans la collection !");
    	       
    	       } else{ int i=0;
    	       deplace(i);
    	       }
    	       
    	       }catch (Exception e) { System.err.println(e);
    	       JOptionPane.showMessageDialog(null,e.getMessage());
       }
    	    
    }
    
    
    //bouton RECHERCHE 2
    /**
     * Affiche le/les manga qui correspond au status introduit dans le champ txtRech2,
     * ainsi que toute les valeurs qui sont associ�es � ce/ces manga
     * @param evt clique sur le bouton recherche status
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	           model.setRowCount(0);// pour vider la liste des mangas
    	      {
    	       Rs = stm.executeQuery("Select * From manga WHERE Status = '"+txtRech2.getSelectedItem()+"'");
    	       }while (Rs.next()){
    	       
    	       Object [] manga2 ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getString(5)};
    	       model.addRow(manga2);
    	       
    	       } if (model.getRowCount () == 0){JOptionPane.showMessageDialog(null,"Aucun manga "
    	       		+ "ne correspond a ce status dans la collection !");
    	       
    	       } else{ int i=0;
    	       deplace(i);
    	       }
    	       
    	       }catch (Exception e) { System.err.println(e);
    	       JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }
    
    /**
     * Initialise la fen�tre de l'application
     */
	private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txtRech = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        txtRech2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        	}
        });
        tble = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNbrTome = new javax.swing.JTextField();
        txtStatus = new javax.swing.JComboBox();
        txtAuteur = new javax.swing.JTextField();
        txtTitre = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(970, 630));
        setLocation(300, 200);
        getContentPane().setLayout(null);

        jButton1.setFont(new Font("Tahoma", Font.BOLD, 14)); 
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supprimer.png"))); 
        jButton1.setText("Supprimer");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1);
        jButton1.setBounds(502, 299, 155, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajouter.png"))); 
        jButton2.setText("Ajouter");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton2);
        jButton2.setBounds(244, 299, 130, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rechercher.png"))); 
        jButton3.setText("manga");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });      
        getContentPane().add(jButton3);
        jButton3.setBounds(244, 215, 119, 40);
        
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rechercher.png"))); 
        jButton9.setText("auteur");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });       
        getContentPane().add(jButton9);
        jButton9.setBounds(244, 258, 119, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/actualiser.png"))); 
        //jButton4.setText("Actualiser");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        getContentPane().add(jButton4);
        jButton4.setBounds(796, 299, 60, 40);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/modifier.png"))); 
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setText("Modifier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton5);
        jButton5.setBounds(375, 299, 129, 40);
        
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14));  
        jButton6.setText("Statistique");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/stat.png")));         
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        
        getContentPane().add(jButton6);
        jButton6.setBounds(654, 299, 155, 40);
        
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rechercher.png"))); 
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        //jButton7.setText("recherche - status");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
       
        getContentPane().add(jButton7);
        jButton7.setBounds(255, 162, 42, 40);

        txtRech.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtRech);
        txtRech.setBounds(361, 242, 130, 30);
        
        txtRech2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "enCours", "terminer" }));
        getContentPane().add(txtRech2);
        txtRech2.setBounds(309, 172, 130, 30);

        jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 55)); 
        jLabel6.setText("Biblioth\u00E8que Manga");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(37, 13, 594, 82);

        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        
        tble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleMouseClicked(evt);
            }
        });
        
        jScrollPane1.setViewportView(tble);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(37, 357, 858, 113);

        jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        jLabel2.setText("id :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(37, 138, 42, 17);

        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        jLabel1.setText("Titre :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(37, 185, 60, 17);

        jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        jLabel3.setText("Auteur :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(37, 226, 74, 17);

        jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        jLabel4.setText("Status :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(37, 269, 74, 17);

        jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        jLabel5.setText("nbrTome  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(37, 312, 111, 17);
        
        txtNbrTome.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtNbrTome);
        txtNbrTome.setBounds(139, 308, 100, 23);

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "enCours", "terminer" }));
        getContentPane().add(txtStatus);
        txtStatus.setBounds(115, 266, 100, 22);

        txtAuteur.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtAuteur);
        txtAuteur.setBounds(115, 222, 100, 23);

        txtTitre.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtTitre);
        txtTitre.setBounds(115, 181, 100, 23);

        txtid.setFont(new java.awt.Font("Tahoma", 0, 14)); 

        getContentPane().add(txtid);
        txtid.setBounds(115, 134, 100, 23);

        
        
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wallp2.jpg"))); 
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -63, 964, 646);

        pack();
        
    }    

}

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionCollection extends javax.swing.JFrame {

    /**
     * Creates new form Gestion_des_notes
     */
	Connecter conn=new Connecter();
	Statement stm;
	ResultSet Rs;
	DefaultTableModel model=new DefaultTableModel();
	
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
 
    
    private void deplace(int i) {
    	try {
    		txtid.setText(model.getValueAt (i, 0).toString());
    		txtno.setText(model.getValueAt (i, 1).toString());
    		txtpr.setText(model.getValueAt (i, 2).toString());
    		txtbr.setSelectedItem(model.getValueAt (i, 3).toString());
    		txtnot.setText(model.getValueAt (i, 4).toString());

    	}catch (Exception e){
    		System.err.println(e);
    		JOptionPane.showMessageDialog(null , "erreur de d�placement"+e.getLocalizedMessage());
    	}
    }
    
    
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
    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {
    	try{
    		int i=tble.getSelectedRow();deplace(i);
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null,"erreur de deplacement "+e.getLocalizedMessage());}
    		}
    
    //bouton AJOUTER
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String id=txtid.getText();
        String titre=txtno.getText();
        String auteur=txtpr.getText();
        String status=txtbr.getSelectedItem().toString();
        String nbrTome=txtnot.getText();
        String requete="insert into manga(id,Titre,Auteur,Status,NbrTome)VALUES('"+
                id+"','"+titre+"','"+auteur+"','"+status+"','"+nbrTome+"')";
        try{
        	stm.executeUpdate(requete);
        	JOptionPane.showMessageDialog(null,"Le manga a bien �t� ajouter � la collection");
        	txtid.setText(id);
        	txtno.setText("");
        	txtpr.setText("");txtbr.setSelectedItem(0);txtnot.setText("");
        	affiche();
        }catch(Exception ex){
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        	}
    }
    
    //bouton ACTUALISER
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    	affiche();
    }
    
    //bouton MODIFIER
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    	try { 
    	            if (JOptionPane.showConfirmDialog (null,"confirmer la modification","modification",
    	                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

    	                stm.executeUpdate("UPDATE manga SET Titre='"+txtpr.getText()+"',Auteur='"+txtpr.getText()+
    	                		"',NbrTome='"+txtnot.getText()+
    	                        "',Status='"+txtbr.getSelectedItem().toString()+
    	                        "' WHERE id= "+txtid.getText());   
    	                affiche();
    	            } 
    	        } catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de modification !!!"+e.getMessage());
    	        System.err.println(e);}
    	    }
    
    
    //bouton SUPPRIMER
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	            if(JOptionPane.showConfirmDialog(null,"voulez vous vraiment supprimer ce manga de votre collection ?"
    	                     ,"supprimer manga",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
    	            if(txtid.getText().length() != 0){
    	        stm.executeUpdate("Delete From manga where id = "+txtid.getText());
    	        affiche();
    	             }
    	            else { JOptionPane.showMessageDialog(null,"veuillez SVP remplire le champ id !");}
    	        
    	        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de suppression \n"+e.getMessage());} 
    	    }
    //bouton STATISTIQUE
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
    	statistique a=new statistique();
    	a.setVisible(true);
    	// TODO add your handling code here:
    }
    //bouton RECHERCHE
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	           model.setRowCount(0);// pour vider la list des mangas
    	      {
    	       Rs = stm.executeQuery("Select * From manga WHERE Titre = '"+txtre.getText()+"'");
    	       }while (Rs.next()){
    	       
    	       Object [] manga ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getString(5)};
    	     model.addRow(manga);
    	       } if (model.getRowCount () == 0){JOptionPane.showMessageDialog(null,"Aucun manga ne correspond a ce titre dans la collection !");
    	       
    	       } else{ int i=0;
    	       deplace(i);
    	       }
    	       
    	       }catch (Exception e) { System.err.println(e);
    	       JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }
    
    //bouton RECHERCHE 2
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	           model.setRowCount(0);// pour vider la list des mangas
    	      {
    	       Rs = stm.executeQuery("Select * From manga WHERE Status = '"+txtre2.getText()+"'");
    	       }while (Rs.next()){
    	       
    	       Object [] manga2 ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getString(5)};
    	     model.addRow(manga2);
    	       } if (model.getRowCount () == 0){JOptionPane.showMessageDialog(null,"Aucun manga ne correspond a ce status dans la collection !");
    	       
    	       } else{ int i=0;
    	       deplace(i);
    	       }
    	       
    	       }catch (Exception e) { System.err.println(e);
    	       JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }
    
    
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
        txtre = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        txtre2 = new javax.swing.JTextField();
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
        txtnot = new javax.swing.JTextField();
        txtbr = new javax.swing.JComboBox();
        txtpr = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(770, 530));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        //jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/supprimer.png"))); 
        jButton1.setText("Supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1);
        jButton1.setBounds(278, 203, 130, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/ajouter.png"))); 
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton2);
        jButton2.setBounds(278, 256, 130, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        //jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/rechercher.png"))); 
        jButton3.setText("recherche - manga");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
       
        getContentPane().add(jButton3);
        jButton3.setBounds(420, 203, 140, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        //jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/modifier.png"))); 
        jButton4.setText("actualiser");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        getContentPane().add(jButton4);
        jButton4.setBounds(420, 256, 140, 40);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        //jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/actualiser.png"))); 
        jButton5.setText("modifier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton5);
        jButton5.setBounds(572, 256, 130, 40);
        
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/nouveau.png"))); // NOI18N
        jButton6.setText("Statistique");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        
        getContentPane().add(jButton6);
        jButton6.setBounds(278, 150, 130, 40);
        
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        //jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/rechercher.png"))); 
        jButton7.setText("recherche - status");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
       
        getContentPane().add(jButton7);
        jButton7.setBounds(420, 150, 140, 40);

        txtre.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtre);
        txtre.setBounds(572, 209, 130, 30);
        
        txtre2.setFont(new java.awt.Font("Tahoma", 0, 14));
        getContentPane().add(txtre2);
        txtre2.setBounds(572, 156, 130, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 48)); 
        jLabel6.setText("Mangath\u00E8que");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(37, 13, 350, 70);

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
        jScrollPane1.setBounds(37, 324, 639, 120);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        jLabel2.setText("id :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 110, 42, 17);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        jLabel1.setText("Titre :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 150, 42, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        jLabel3.setText("Auteur :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 190, 53, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        jLabel4.setText("Status");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 240, 60, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        jLabel5.setText("nbrTome  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 294, 74, 17);

        txtnot.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtnot);
        txtnot.setBounds(115, 290, 100, 23);

        txtbr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "enCours", "terminer" }));
        getContentPane().add(txtbr);
        txtbr.setBounds(115, 237, 100, 22);

        txtpr.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtpr);
        txtpr.setBounds(115, 186, 100, 23);

        txtno.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        getContentPane().add(txtno);
        txtno.setBounds(115, 146, 100, 23);

        txtid.setFont(new java.awt.Font("Tahoma", 0, 14)); 

        getContentPane().add(txtid);
        txtid.setBounds(115, 106, 100, 23);

        //jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/wallpaper7.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 760, 500);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("ajouter");

        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("modifier");

        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem3.setText("supprimer");

        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem4.setText("actualiser");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("rechercher");

        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("realiser par");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }

    public static void main(String args[]) {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionCollection().setVisible(true);
            }
        });
    }
    
    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tble;
    private javax.swing.JComboBox txtbr;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtnot;
    private javax.swing.JTextField txtpr;
    private javax.swing.JTextField txtre;
    private javax.swing.JTextField txtre2;

}

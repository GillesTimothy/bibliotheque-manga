import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        } catch(Exception e){System.err.println(e);}
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
    		JOptionPane.showMessageDialog(null , "erreur de déplacement"+e.getLocalizedMessage());
    	}
    }
    
    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleMouseClicked
    	try{
    		int i=tble.getSelectedRow();deplace(i);
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null,"erreur de deplacement "+e.getLocalizedMessage());}
    		}//GEN-LAST:event_tbleMouseClicked	
    
    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtre = new javax.swing.JTextField();
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

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/supprimer.png"))); // NOI18N
        jButton1.setText("Supprimer");

        getContentPane().add(jButton1);
        jButton1.setBounds(180, 400, 143, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/ajouter.png"))); // NOI18N
        jButton2.setText("Ajouter");

        getContentPane().add(jButton2);
        jButton2.setBounds(40, 350, 130, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/rechercher.png"))); // NOI18N
        jButton3.setText("recherche ");
       
        getContentPane().add(jButton3);
        jButton3.setBounds(380, 380, 150, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/modifier.png"))); // NOI18N
        jButton4.setText("actualiser");
        
        getContentPane().add(jButton4);
        jButton4.setBounds(180, 350, 140, 40);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/actualiser.png"))); // NOI18N
        jButton5.setText("modifier");

        getContentPane().add(jButton5);
        jButton5.setBounds(40, 400, 130, 40);

        txtre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    
        getContentPane().add(txtre);
        txtre.setBounds(560, 380, 130, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel6.setText("Mangath\u00E8que");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(260, 23, 350, 70);

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
        jScrollPane1.setViewportView(tble);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 140, 374, 90);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("id :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 110, 42, 17);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Titre :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 150, 42, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Auteur :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 190, 53, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Status");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 240, 60, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("nbrTome  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 294, 74, 17);

        txtnot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtnot);
        txtnot.setBounds(170, 290, 100, 23);

        txtbr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "enCours", "terminer" }));
        getContentPane().add(txtbr);
        txtbr.setBounds(170, 240, 100, 22);

        txtpr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtpr);
        txtpr.setBounds(170, 190, 100, 23);

        txtno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtno);
        txtno.setBounds(170, 150, 100, 23);

        txtid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        getContentPane().add(txtid);
        txtid.setBounds(170, 110, 100, 23);

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
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionCollection().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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

}

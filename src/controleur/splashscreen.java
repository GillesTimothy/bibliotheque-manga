package controleur;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vue.gestionCollection;

public class splashscreen extends JFrame {

	private JPanel contentPane;
	
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel6;
	/**
	 * Create the frame.
	 */
	public splashscreen() {
		
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 630);
		contentPane = new JPanel();
		
		setPreferredSize(new Dimension(970, 630));
        setLocation(300, 200);
        getContentPane().setLayout(null);
        
        jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 55)); 
        //jLabel6.setText("Mangath\u00E8que");
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/biblimanga.png"))); 
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-221, 53, 1025, 116);

		
		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wallp2.jpg"))); 
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -63, 964, 646);
        
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        
        
        
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splashscreen frame = new splashscreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {
    	gestionCollection C=new gestionCollection();
    	C.setVisible(true);
	}	
	
}

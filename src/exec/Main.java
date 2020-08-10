package exec;

import vue.splashscreen;

public class Main {
	
	public static void main(String args[]) {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	splashscreen b=new splashscreen();
            	b.setVisible(true);
                //new gestionCollection().setVisible(true);
            }
        });
    }
	
}

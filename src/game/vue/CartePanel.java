package game.vue;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CartePanel extends JPanel {

	public CartePanel(){
	    this.setSize(900, 900);
	    this.setLayout(new BorderLayout());
	    this.add(new JButton("CENTER"), BorderLayout.CENTER);
	    this.add(new JButton("NORTH"), BorderLayout.NORTH);
	    this.add(new JButton("SOUTH"), BorderLayout.SOUTH);
	    this.add(new JButton("WEST"), BorderLayout.WEST);
	    this.add(new JButton("EAST"), BorderLayout.EAST);
	    this.setVisible(true);
	  }  
	
}

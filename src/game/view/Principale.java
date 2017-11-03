package game.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import game.view.map.MapView; 


public class Principale extends JFrame {

	private static final long serialVersionUID = 8894838981626779133L;

	public Principale() {
	    this.setTitle("GAME");
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    MapView mv = new MapView();
	    this.setLayout(new GridLayout());
	    this.add(mv);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
 	}

}

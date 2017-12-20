package game.view.mapView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GeneralView extends JPanel {
	
	private static final long serialVersionUID = 1L;
		
	
	public GeneralView(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 1;
		c.weighty = 2;
		c.gridwidth = 2;
		c.ipady = 500;
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		this.add(new MapView(), c);
		c.gridx = 0;
		c.ipady = 0;
		c.gridy = 1;
		c.gridheight = 1;
		this.add(new ControlView(), c);

		this.setBounds(0, 0, 1280, 900);
	}
	
}

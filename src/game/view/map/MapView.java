package game.view.map;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.model.map.Carte;
import game.model.map.factory.CarteFactory;
import game.model.map.factory.CarteType;

public class MapView extends JPanel {
	
	private static final long serialVersionUID = 1795048375336590913L;

	public MapView() {
		Carte c = new CarteFactory().creerCarte(CarteType.FERMIERE, 10);
	    this.setLayout(new GridLayout(c.getDimension(), c.getDimension()));
	    for (int i = 0; i < c.getListeCases().size(); i++) {
			this.add(new JButton(c.getListeCases().get(i).getCoordonnees().getA()
						+ ", " + c.getListeCases().get(i).getCoordonnees().getB()));
		}
	    this.setVisible(true);
	}
	
}

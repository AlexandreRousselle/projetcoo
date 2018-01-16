package game.view.mapView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import game.model.map.tile.Case;
import game.persistance.UniteMapper;



public class GeneralView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
		
	MapView m;
	ControlView co;
	
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
		m = new MapView();
		m.setObserver(this);
		this.add(m, c);
		c.gridx = 0;
		c.ipady = 0;
		c.gridy = 1;
		c.gridheight = 1;
		co = new ControlView();
		co.setObserver(this);
		this.add(co, c);
		
		this.setBounds(0, 0, 1280, 900);
	}
	
	public void update(Object arg) {
		this.update(null, arg);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Case c = (Case) arg;
		co.coordonnees_case.setText(c.getCoordonnees().getA() + ", " + c.getCoordonnees().getB());
		co.type_case.setText(c.getCase_type().toString());
		try {
			co.unites_case.setText(UniteMapper.getInstance().findByIdCase(c.getId_case()).toString());
		} catch (NullPointerException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			co.unites_case.setText("Pas d'unites");
		}
		co.revalidate();
		co.repaint();
	}
	
	
}

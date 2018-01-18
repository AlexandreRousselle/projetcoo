package game.view.mapView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.main.Jeu;
import game.model.action.Action;
import game.model.action.ConstruireVilleAction;
import game.model.action.CreerArmeeAction;
import game.model.action.DeplacerArmeeAction;
import game.model.map.tile.Case;
import game.persistance.JoueurMapper;
import game.persistance.PartieMapper;
import game.persistance.UniteMapper;
import game.persistance.VirtualCase;



public class GeneralView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
		
	MapView m;
	ControlView co;
	VirtualCase caseSelected;
	
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
		co.ressources_joueur.setText("un chiffre");
		this.add(co, c);
		
		this.setBounds(0, 0, 1280, 900);
	}
	
	public void update(Object arg) {
		this.update(null, arg);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg.equals("construire")) {
			Action a = new ConstruireVilleAction();
			String m = a.doAction(this.caseSelected);
	    	JOptionPane.showMessageDialog(null, m, "Message", 1);
	    	Jeu.getInstance().getCurrent_partie().setMapJoueurs(null);
	    	Jeu.getInstance().getCurrent_partie().getMapJoueurs();
	    	co.ressources_joueur.setText("" + Jeu.getInstance().getCurrent_partie()
	    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()));
		} else if (arg.equals("creer")) {
			Action a = new CreerArmeeAction();
			String m = a.doAction(this.caseSelected);
	    	JOptionPane.showMessageDialog(null, m, "Message", 1);
	    	Jeu.getInstance().getCurrent_partie().setMapJoueurs(null);
	    	Jeu.getInstance().getCurrent_partie().getMapJoueurs();
	    	co.ressources_joueur.setText("" + Jeu.getInstance().getCurrent_partie()
	    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()));
	    	
		} else if (arg.equals("deplacer")) {
			Action a = new DeplacerArmeeAction();
			String m = a.doAction(this.caseSelected);
	    	JOptionPane.showMessageDialog(null, m, "Message", 1);
	    	Jeu.getInstance().getCurrent_partie().setMapJoueurs(null);
	    	Jeu.getInstance().getCurrent_partie().getMapJoueurs();
	    	co.ressources_joueur.setText("" + Jeu.getInstance().getCurrent_partie()
	    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()));
		} else {
			co.message_case.setText("");
			caseSelected = (VirtualCase) arg;
			co.coordonnees_case.setText(caseSelected.getCoordonnees().getA() + ", " + caseSelected.getCoordonnees().getB());
			co.type_case.setText(caseSelected.getCase_type().toString());
			try {
				String res = "<html>";
				for (int i = 0; i < UniteMapper.getInstance().findByIdCase(caseSelected.getId_case()).size(); i++) {
					res += UniteMapper.getInstance().findByIdCase(caseSelected.getId_case()).get(i).toString() + "<br>";
				}
				res += "</html>";
				co.unites_case.setText(res);
			} catch (NullPointerException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			co.revalidate();
			co.repaint();
		}
	}
	
	
}

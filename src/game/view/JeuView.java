package game.view;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.main.EtatJeu;
import game.main.Jeu;

public class JeuView extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	Jeu jeu;
	
	public JeuView(){
		super();
		jeu = new Jeu();
		jeu.addObserver(this);
		Container c = new LoginView();
		this.setContentPane(c);
		this.setSize(c.getWidth(), c.getHeight());
		this.setTitle(c.getName());
		this.setResizable(false);	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void changePanel(JPanel jp){
		this.removeAll();
		this.setContentPane(jp);
	}
	
	public void refresh(EtatJeu ej) {
		Container contenu = this.getContentPane();
		switch (ej) {
        case PAGE_LOGIN:
        	this.changePanel(new LoginView());
        /*case MENU_CREATION:
        	this.changePanel(new LoginView());
        case MENU_PRINCIPAL:
        	this.changePanel(new LoginView());
        case MENU_REJOINDRE:
        	this.changePanel(new LoginView());*/
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
}

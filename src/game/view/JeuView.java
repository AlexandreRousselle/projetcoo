package game.view;

import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.javafx.image.impl.General;

import game.main.EtatJeu;
import game.main.Jeu;
import game.view.mapView.GeneralView;
import game.view.mapView.MapView;

public class JeuView extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	protected Jeu jeu;
	protected Container c;

	public JeuView(){
		super();
		this.jeu = Jeu.getInstance();
		this.jeu.addObserver(this);
		this.c = new PreView();
		this.setContentPane(c);
		this.setSize(1280, 720);
		this.setTitle(jeu.getNom_jeu());
		this.setLocationRelativeTo(null);
		this.setResizable(false);	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
		    Thread.sleep(2000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		this.setVisible(false);
		this.changePanel(new LoginView());
		this.setVisible(true);
	}
	
	
	public void changePanel(JPanel jp){ 
		this.getContentPane().removeAll();
		c = jp;
		this.setContentPane(c);
		this.setSize(jp.getWidth(), jp.getHeight());
		revalidate();
		repaint();
		this.setLocationRelativeTo(null);
	}
	
	public void refresh(EtatJeu ej) {
		System.out.println(ej);
		switch (ej) {
        case PAGE_LOGIN:
        	this.changePanel(new LoginView());
        	break;
        case MENU_PRINCIPAL:
        	this.changePanel(new MenuPrincipalView());
        	break;
        case MENU_NOUVELLE:
        	this.changePanel(new NouvellePartieView());
        	break;
        case MENU_REJOINDRE:
        	this.changePanel(new ChoixPartieView(1));
        	break;
        case MENU_VOIR:
        	this.changePanel(new ChoixPartieView(2));
        	break;
        case ATTENTE_PARTIE:
        	this.changePanel(new AttenteCreationPartieView());
        	break;
        case PARTIE_EN_COURS:
        	this.changePanel(new GeneralView());
        	break;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		EtatJeu ej = (EtatJeu) arg;
		refresh(ej);
	}
	
}

package game.model.joueur;

public class JoueurHumain extends Joueur {

	public JoueurHumain(String nom_joueur, JoueurTribu joueur_tribu) {
		super(nom_joueur, JoueurType.JOUEURHUMAIN, joueur_tribu);
	}
	
}

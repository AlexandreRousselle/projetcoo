package game.model.partie;

import java.util.Date;
import java.time.Instant;
import java.util.List;

import game.model.joueur.Joueur;
import game.model.joueur.buildings.Construction;
import game.model.joueur.buildings.ConstructionType;
import game.model.map.Carte;
import game.model.utils.Coordonnees;

public class Partie {
	
	private int id_partie;
	private String nom_partie;
	private Carte carte; 
	private Date date;
	private List<Joueur> listeJoueurs;
	private EtatPartie etat_partie;
	
	public Partie(int id_partie, String nom_partie, Carte carte, List<Joueur> listeJoueurs) {
		this.id_partie = id_partie;
		this.nom_partie = nom_partie;
		this.carte = carte;
		this.carte.setPartie(this);
		this.date = Date.from(Instant.now());
		this.listeJoueurs = this.genererVilleJoueur(listeJoueurs);
	}
	
	public List<Joueur> genererVilleJoueur(List<Joueur> listeJoueurs) {
		for (int i = 0; i < listeJoueurs.size(); i++) {
			int posX = (int) (Math.floor(Math.random() * 10) + 1 );
			int posY = (int) (Math.floor(Math.random() * 10) + 1 );
			Coordonnees c = new Coordonnees(posX, posY);
			for (int j = 0; j < this.carte.getListeCases().size(); j++) {
				if(this.carte.getListeCases().get(j).getCoordonnees().getA() == c.getA()
						&& this.carte.getListeCases().get(j).getCoordonnees().getB() == c.getB()){
					listeJoueurs.get(i).getConstructions().add(
							new Construction(ConstructionType.VILLE, listeJoueurs.get(i), c));
					this.carte.getListeCases().get(j).setConstruction(
							listeJoueurs.get(i).getConstructions().get(0));
				}
			}
		}
		return listeJoueurs;
	}

	public void ajouterJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}
	
	public String toString() {
		String res = "Partie n�" + this.id_partie + " -> Nom de partie : " + this.nom_partie + " -> Cr��e le : " + this.date.toString() + "\n";
		for (int i = 0; i < this.listeJoueurs.size(); i++) {
			res += listeJoueurs.get(i).toString() + "\n";
		}
		return res;
	}
	
	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public int getId_partie() {
		return id_partie;
	}

	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
	}

	public String getNom_partie() {
		return nom_partie;
	}

	public void setNom_partie(String nom_partie) {
		this.nom_partie = nom_partie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EtatPartie getEtat_partie() {
		return etat_partie;
	}

	public void setEtat_partie(EtatPartie etat_partie) {
		this.etat_partie = etat_partie;
	}
	
}

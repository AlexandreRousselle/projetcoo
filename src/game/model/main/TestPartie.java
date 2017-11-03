package game.model.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import game.model.joueur.Joueur;
import game.model.joueur.JoueurTribu;
import game.model.map.factory.CarteFactory;
import game.model.map.factory.CarteType;
import game.model.partie.Partie;
import game.user.Utilisateur;

public class TestPartie {

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Bienvenue dans le Gansta Game !");
			System.out.println("Combien de joueurs ?");
			int nbJoueurs = Integer.parseInt(br.readLine());
			List<Joueur> listeJoueurs = new ArrayList<Joueur>();
			for (int i = 0; i < nbJoueurs; i++) {
				/*System.out.println("Entrez le nom du Joueur " + (i+1));
				String nom = br.readLine();*/
				int numero_tribu = 0;
				Utilisateur u = new Utilisateur("alex" + i, "alex" + i);
				System.out.println("Choisissez la tribu du Joueur " + (i+1));
				for (int j = 0; j < JoueurTribu.values().length; j++) {
					System.out.println(j+1 + " - " + JoueurTribu.values()[j]);
				}
				numero_tribu = Integer.parseInt(br.readLine())-1;
				JoueurTribu joueur_tribu = JoueurTribu.values()[numero_tribu];
				Joueur j = new Joueur(u, joueur_tribu);
				listeJoueurs.add(j);
			}
			System.out.println("Choisissez le type de carte : ");
			System.out.println("1 - FERMIERE");
			System.out.println("2 - FORESTIERE");
			System.out.println("3 - MONTAGNEUSE");
			int carte_type = Integer.parseInt(br.readLine())-1;
			Partie p = new Partie("P1", new CarteFactory().creerCarte(CarteType.values()[carte_type], 10), listeJoueurs);
			System.out.println(p.getCarte().toStringModelise());
			System.out.println(p.getListeJoueurs().get(0));
			System.out.println(p.getListeJoueurs().get(1));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

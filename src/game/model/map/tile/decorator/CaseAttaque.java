package game.model.map.tile.decorator;

import game.model.map.Carte;
import game.model.map.tile.Case;

/**
 * Classe Case Attaque
 * @author roussellea
 *
 */
public class CaseAttaque extends DecorateurCase {

	/**
	 * Constructeur Case Attaque
	 * @param carte
	 * @param caseDecoree
	 */
	public CaseAttaque(Carte carte, Case caseDecoree) {
		super(carte, caseDecoree, EffetType.ATTAQUEPLUS);
	}

	/**
	 * Get libellé
	 */
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return this.caseDecoree.getLibelle() + ", "
				+ EffetType.ATTAQUEPLUS.toString() + " : Gain d'attaque sur cette case !";
	}
	
}

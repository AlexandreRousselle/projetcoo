package game.model.map.tile.decorator;

import game.model.map.Carte;
import game.model.map.tile.Case;

/**
 * Classe Case Défense
 * @author roussellea
 *
 */
public class CaseDefense extends DecorateurCase {
	
	/**
	 * Constructeur Case Défense
	 * @param carte
	 * @param caseDecoree
	 */
	public CaseDefense(Carte carte, Case caseDecoree) {
		super(carte, caseDecoree, EffetType.DEFENSEPLUS);
	}

	/**
	 * Get libellé
	 */
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return this.caseDecoree.getLibelle() + ", "
				+ EffetType.DEFENSEPLUS.toString() + " : Gain de defense sur cette case !";
	}
	
}

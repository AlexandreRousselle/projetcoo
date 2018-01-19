package game.model.map.tile.decorator;

import game.model.map.Carte;
import game.model.map.tile.Case;

/**
 * Classe abstraite qui décore les cases
 * @author roussellea
 *
 */
public abstract class DecorateurCase extends Case {

	protected Case caseDecoree;

	/**
	 * Constructeur Decorateur des cases
	 * @param carte
	 * @param caseDecoree
	 * @param effet_type
	 */
	public DecorateurCase(Carte carte, Case caseDecoree, EffetType effet_type) {
		super(carte, caseDecoree.getCoordonnees(), caseDecoree.getBuild_on(), caseDecoree.getCase_type());
		this.setEffet_type(effet_type);
		this.caseDecoree = caseDecoree;
	}

	/**
	 * Get la case décorée
	 * @return
	 */
	public Case getCaseDecoree() {
		return caseDecoree;
	}

	/**
	 * Set la case décorée
	 * @param caseDecoree
	 */
	public void setCaseDecoree(Case caseDecoree) {
		this.caseDecoree = caseDecoree;
	}
	
	/**
	 * Fonction abstraite qui retourne le libellé d'une case
	 */
	public abstract String getLibelle();
	
}

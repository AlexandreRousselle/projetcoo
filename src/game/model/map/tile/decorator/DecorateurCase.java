package game.model.map.tile.decorator;

import game.model.map.Carte;
import game.model.map.tile.Case;

public abstract class DecorateurCase extends Case {

	protected Case caseDecoree;

	public DecorateurCase(Carte carte, Case caseDecoree, EffetType effet_type) {
		super(carte, caseDecoree.getCoordonnees(), caseDecoree.getBuild_on(), caseDecoree.getCase_type());
		this.setEffet_type(effet_type);
		this.caseDecoree = caseDecoree;
	}

	public Case getCaseDecoree() {
		return caseDecoree;
	}

	public void setCaseDecoree(Case caseDecoree) {
		this.caseDecoree = caseDecoree;
	}
	
	public abstract String getLibelle();
	
}

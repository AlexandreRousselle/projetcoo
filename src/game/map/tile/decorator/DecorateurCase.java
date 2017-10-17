package game.map.tile.decorator;

import game.map.tile.Case;

public abstract class DecorateurCase extends Case {

	protected Case caseDecoree;

	public DecorateurCase(Case caseDecoree, EffetType effet_type) {
		super(caseDecoree.getCoordonnees(), caseDecoree.getCase_access(), caseDecoree.getCase_type());
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

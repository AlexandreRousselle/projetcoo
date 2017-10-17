package game.map.tile.decorator;

import game.map.tile.Case;

public class CaseAttaque extends DecorateurCase {

	public CaseAttaque(Case caseDecoree) {
		super(caseDecoree, EffetType.ATTAQUEPLUS);
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return this.caseDecoree.getLibelle() + ", "
				+ EffetType.ATTAQUEPLUS.toString() + " : Gain d'attaque sur cette case !";
	}
	
}

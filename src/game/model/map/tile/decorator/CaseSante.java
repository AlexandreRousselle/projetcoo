package game.model.map.tile.decorator;

import game.model.map.tile.Case;

public class CaseSante extends DecorateurCase {

	public CaseSante(Case caseDecoree) {
		super(caseDecoree, EffetType.SANTEPLUS);
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return this.caseDecoree.getLibelle() + ", "
				+  EffetType.SANTEPLUS.toString() + " : Gain de santé sur cette case !";
	}

	
}

package game.map.tile.decorator;

import game.map.tile.Case;

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

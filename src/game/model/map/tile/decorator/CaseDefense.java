package game.model.map.tile.decorator;

import game.model.map.Carte;
import game.model.map.tile.Case;

public class CaseDefense extends DecorateurCase {
	
	public CaseDefense(Carte carte, Case caseDecoree) {
		super(carte, caseDecoree, EffetType.DEFENSEPLUS);
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return this.caseDecoree.getLibelle() + ", "
				+ EffetType.DEFENSEPLUS.toString() + " : Gain de defense sur cette case !";
	}
	
}
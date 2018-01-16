package game.model.map.tile.decorator;

import game.model.map.Carte;
import game.model.map.tile.Case;

public class CaseAttaque extends DecorateurCase {

	public CaseAttaque(Carte carte, Case caseDecoree) {
		super(carte, caseDecoree, EffetType.ATTAQUEPLUS);
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return this.caseDecoree.getLibelle() + ", "
				+ EffetType.ATTAQUEPLUS.toString() + " : Gain d'attaque sur cette case !";
	}
	
}

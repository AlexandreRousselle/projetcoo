package game.map.tile;

import game.utils.Coordonnees;

public class CaseAccessible extends Case {

	public CaseAccessible(Coordonnees coordonnees, CaseType case_type) {
		super(coordonnees, CaseAccessibilite.ACCESSIBLE, case_type);
	}

}

package game.map.tile;

import game.utils.Coordonnees;

public class CaseNonAccessible extends Case {

	public CaseNonAccessible(Coordonnees coordonnees, CaseType case_type) {
		super(coordonnees, CaseAccessibilite.NONACCESSIBLE, case_type);
	}

}

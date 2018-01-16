package game.model.map.tile;

public enum CaseType {
	PLAINE (0),
	CHAMP (1),
	MONTAGNE (2);
	
	private int value;
	
	private CaseType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}

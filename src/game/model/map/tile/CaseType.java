package game.model.map.tile;

public enum CaseType {
	CHAMP (1),
	PLAINE (2),
	MONTAGNE (3);
	
	private int value;
	
	private CaseType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}

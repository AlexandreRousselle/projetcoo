package game.model.map.tile;

public enum CaseType {
	PLAINE (1),
	CHAMP (2),
	FORET (3),
	MONTAGNE (4);
	
	private int value;
	
	private CaseType(int value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		System.out.println(CaseType.valueOf("PLAINE").value);
	}
	
}

package game.view;

public class TestPrincipale {

	private static JeuView ce;

	public static void main(String[] args) {
		setCe(new JeuView());
	}

	public static JeuView getCe() {
		return ce;
	}

	public static void setCe(JeuView ce) {
		TestPrincipale.ce = ce;
	}
	
}

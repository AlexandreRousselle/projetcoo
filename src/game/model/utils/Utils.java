package game.model.utils;

import java.util.Random;

public class Utils {

	public static void main(String[] args) {
		Random rand = new Random();
		int nbAlea = rand.nextInt(900);
		System.out.println(nbAlea);
	}
	
}

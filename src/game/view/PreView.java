package game.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.main.Jeu;


public class PreView extends JPanel {

	private static final long serialVersionUID = 1L;

	public PreView (){
		this.setBounds(0,0,1280,720);
	}
	
    public void paintComponent(Graphics g) {
    	Image img = null;
		try {
			img = ImageIO.read(Jeu.getInstance().getFileByKey("splash_screen"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }
	
}

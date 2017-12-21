package game.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SoulsButton extends JButton implements MouseListener{

	//Attributes
	private ImageIcon image = new ImageIcon("ressources/button.png");
	private ImageIcon hover = new ImageIcon("ressources/button_hover.png");
	private ImageIcon clicked = new ImageIcon("ressources/button_clicked.png");
	
	public SoulsButton(int longueur, int largeur){
		Image tmpImage = this.image.getImage(); // transform it 
		Image newimg = tmpImage.getScaledInstance(longueur, largeur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		this.image = new ImageIcon(newimg);
		
		tmpImage = this.hover.getImage(); // transform it 
		newimg = tmpImage.getScaledInstance(longueur, largeur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		this.hover = new ImageIcon(newimg);
		
		tmpImage = this.clicked.getImage(); // transform it 
		newimg = tmpImage.getScaledInstance(longueur, largeur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		this.clicked = new ImageIcon(newimg);

		this.setIcon(image);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setForeground(Color.WHITE);
		
		this.addMouseListener(this);
	}
	
	//Constructor
	public SoulsButton(String label, int longueur, int largeur){
		super(label);

		Image tmpImage = this.image.getImage(); // transform it 
		Image newimg = tmpImage.getScaledInstance(longueur, largeur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		this.image = new ImageIcon(newimg);
		
		tmpImage = this.hover.getImage(); // transform it 
		newimg = tmpImage.getScaledInstance(longueur, largeur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		this.hover = new ImageIcon(newimg);
		
		tmpImage = this.clicked.getImage(); // transform it 
		newimg = tmpImage.getScaledInstance(longueur, largeur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		this.clicked = new ImageIcon(newimg);

		this.setIcon(image);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setForeground(Color.WHITE);
		
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setIcon(clicked);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		  if((e.getY() > 0 && e.getY() < this.getHeight()) && (e.getX() > 0 && e.getX() < this.getWidth())){
			  this.setIcon(hover);
		  }
		  else{
			  this.setIcon(image);  
		  }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setIcon(hover);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setIcon(image);
	}

}

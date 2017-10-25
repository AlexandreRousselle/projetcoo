package game.vue;

import javax.swing.JFrame; 


public class Principale extends JFrame {

  public Principale(){
    this.setTitle("GAME");
    this.setSize(1600, 900);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().add(new CartePanel());
    this.setVisible(true);
  }      
  
}

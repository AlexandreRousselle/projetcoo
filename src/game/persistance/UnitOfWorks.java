package game.persistance;

import game.model.Observable;
import game.model.Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class UnitOfWorks implements ActionListener,Observer{
	
	//Attributes
	private List<Observable> update = new ArrayList<Observable>();
	
	private VisiteurUpdate creator = new VisiteurUpdate();
	
	private static UnitOfWorks instance;
	
	//Constrctor
	private UnitOfWorks(){
		 // this === c'est la classe qui implemente le ActionListener dans notre cas c'est this (notre classe)
		 new Timer(2000,this).start();
	}

	//Methods
	public static UnitOfWorks getInstance(){
		if(instance == null)
			instance = new UnitOfWorks();
		return instance;
	}

	@Override
	public void update(Observable o) {
		if(!this.update.contains(o))
			this.update.add(o);
	}
	
	public void commit(){
		for(Observable o : this.update){
			this.creator.visit(o);
		}
		this.update.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		commit();
	}

}

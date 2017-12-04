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
	private List<Observable> create = new ArrayList<Observable>();
	private List<Observable> update = new ArrayList<Observable>();
	private List<Observable> delete = new ArrayList<Observable>();
	
	private VisiteurCreate creator = new VisiteurCreate();
	
	private static UnitOfWorks instance;
	
	//Constrctor
	private UnitOfWorks(){
		 // this === c'est la classe qui implemente le ActionListener dans notre cas c'est this (notre classe)
		 new Timer(100000,this).start();
	}

	//Methods
	public UnitOfWorks getInstance(){
		if(instance == null)
			instance = new UnitOfWorks();
		return instance;
	}

	@Override
	public void create(Observable o) {
		if(!this.create.contains(o))
			this.create.add(o);
	}

	@Override
	public void update(Observable o) {
		if(!this.update.contains(o))
			this.update.add(o);
	}

	@Override
	public void delete(Observable o) {
		if(this.update.contains(o))
			this.update.remove(o);
		if(this.create.contains(o)){
			this.create.remove(o);
		}
		else {
			this.delete.add(o);
		}
	}
	
	public void commit(){
		for(Observable o : this.create){
			creator.visit(o);
		}
		this.create.clear();

		for(Observable o : this.update){
			
		}
		this.update.clear();

		for(Observable o : this.delete){
	
		}
		this.delete.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		commit();
		
	}

}

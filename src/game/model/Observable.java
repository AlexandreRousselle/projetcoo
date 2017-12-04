package game.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable implements Visitable {

	//Attributes
	private List<Observer> observers = new ArrayList<Observer>();
	
	//Methods
	public void notifyCreate(){
		for(Observer o : observers){
			o.create(this);
		}
	}
	
	public void notifyUpdate(){
		for(Observer o : observers){
			o.update(this);
		}
	}
	
	public void notifyDelete(){
		for(Observer o : observers){
			o.delete(this);
		}
	}
	
	public void addObserver(Observer o ){
		this.observers.add(o);
	}
}

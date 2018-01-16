package game.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable implements Visitable {

	//Attributes
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void notifyUpdate(){
		for(Observer o : observers){
			o.update(this);
		}
	}
	
	public void addObserver(Observer o){
		this.observers.add(o);
	}
}

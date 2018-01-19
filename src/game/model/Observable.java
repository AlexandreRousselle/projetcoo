package game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author roussellea
 *
 */
public abstract class Observable implements Visitable {

	//Attributes
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 
	 */
	public void notifyUpdate(){
		for(Observer o : observers){
			o.update(this);
		}
	}
	
	/**
	 * 
	 * @param o
	 */
	public void addObserver(Observer o){
		this.observers.add(o);
	}
}

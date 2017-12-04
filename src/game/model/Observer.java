package game.model;

public interface Observer {

	public void create(Observable o);
	
	public void update(Observable o);
	
	public void delete(Observable o);
}

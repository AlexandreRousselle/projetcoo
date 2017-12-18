package game.persistance;

import game.model.Observable;
import game.model.Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class UnitOfWorks implements ActionListener,Observer{
	
	//Attributes
	private List<Observable> update = new ArrayList<Observable>();
	
	private VisiteurCreate creator = new VisiteurCreate();
	
	private static UnitOfWorks instance;
	
	//Constrctor
	private UnitOfWorks(){
		 // this === c'est la classe qui implemente le ActionListener dans notre cas c'est this (notre classe)
		 new Timer(100000,this).start();
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
		try {
			DBconfig.getInstance().getConnection().commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.update.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		commit();
	}

}

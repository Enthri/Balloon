package DragAndDrop;

import com.troi.balloon.Button;
import com.troi.balloon.Panel;

import util.panelDimension;

public class CommandManager extends ObjectManager {//inherits all data from the Object manager class

	public CommandManager(Panel container,panelDimension dimension, String state) {
		super(container,dimension, state);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		this.setType("Command Manager");
	}
	public void newPanel()//overrriden
	{
		this.getPanels().add(new CommandManager(this,this.getDimension(),"MainViewer"));//constructs object and adds it to the parameters for this listed method
	}

}
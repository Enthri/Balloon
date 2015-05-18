package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Panel;

public class MethodManager extends ObjectManager{//inherits all data from the Object manager class

	public MethodManager(Panel container,panelDimension dimension, String state) {
		super(container,dimension, state);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		this.setType("Method Manager");
	}
	public void newPanel()
	{
		this.getPanels().add(new CommandManager(this,this.getDimension(),"MainViewer"));//constructs object and adds it to the parameters for this listed method
	}
}

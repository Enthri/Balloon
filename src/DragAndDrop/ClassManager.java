package DragAndDrop;


import com.troi.balloon.Button;
import com.troi.balloon.Panel;

import util.panelDimension;

public class ClassManager extends ObjectManager {//inherits all data from the Object manager class

	public ClassManager(Panel container,panelDimension dimension, String state) {//COnstructor
		super(container,dimension, state);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		this.setType("ClassManager");
	}
	public void newPanel()//overrides the method listed within Panel Obejct
	{
		this.getPanels().add(new MethodManager(this,this.getDimension(),"MainViewer"));
	}

}

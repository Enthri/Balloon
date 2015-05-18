package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;
import com.troi.balloon.Panel;

public class PackageManager extends ObjectManager {//inherits all data from the Object manager class

	public PackageManager(Panel container,panelDimension dimension, String state) {
		super(container,dimension, state);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		this.setType("Package Manager");
	}
	public void newPanel()
	{
		this.getPanels().add(new ClassManager(this,this.getDimension(),"MainViewer"));//constructs object and adds it to the parameters for this listed method
	}
	
	
}

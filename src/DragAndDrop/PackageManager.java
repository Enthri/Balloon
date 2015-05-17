package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;
import com.troi.balloon.Panel;

public class PackageManager extends ObjectManager {

	public PackageManager(Panel container,panelDimension dimension, String state) {
		super(container,dimension, state);
		this.setType("Package Manager");
	}
	public void newPanel()
	{
		this.getPanels().add(new ClassManager(this,this.getDimension(),"MainViewer"));
	}
	
	
}

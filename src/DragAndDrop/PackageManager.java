package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;

public class PackageManager extends ObjectManager {

	public PackageManager(panelDimension dimension, String state) {
		super(dimension, state);
		this.addButton(new Button(this, "Small"));
	}
	
	
}

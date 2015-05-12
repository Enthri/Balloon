package DragAndDrop;

import com.troi.balloon.Button;

import util.panelDimension;

public class ClassManager extends ObjectManager {

	public ClassManager(panelDimension dimension, String state) {
		super(dimension, state);
		addNewButton(new Button(this));
	}

}

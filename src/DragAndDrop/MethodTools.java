package DragAndDrop;


import com.troi.balloon.Button;

import util.panelDimension;

public class MethodTools extends Tools{

	public MethodTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new Button(this));
		this.setType("Method Tools");
	}

}

package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;

public class ClassTools extends Tools {

	public ClassTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new Button(this, "For  "));
		addNewButton(new Button(this, "If   "));
		addNewButton(new Button(this, "Test "));
		this.setType("ClassTools");
	}



}

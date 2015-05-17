package DragAndDrop;

import javax.swing.JFrame;

import com.troi.balloon.Button;

import util.panelDimension;

public class ClassTools extends Tools {

	public ClassTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new Button(this));
		this.setType("ClassTools");
	}



}

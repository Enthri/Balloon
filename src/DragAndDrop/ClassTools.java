package DragAndDrop;

import javax.swing.JFrame;

import Buttons.NewClassButton;

import com.troi.balloon.Button;

import util.panelDimension;

public class ClassTools extends Tools {

	public ClassTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new NewClassButton(this, new MethodManager(dimension,string)));
	}



}

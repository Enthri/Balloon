package DragAndDrop;

import com.troi.balloon.Button;
import util.panelDimension;

public class CommandTools extends Tools {//inheritos all data from Tools class

	public CommandTools(panelDimension dimension, String string) {
		super(dimension,string);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		addNewButton(new Button(this));//constucted new button and adds to parameters for method listed within this class
		this.setType("Command Tools");
	}

}

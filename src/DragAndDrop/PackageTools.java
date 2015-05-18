package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;

public class PackageTools extends Tools{//inheritos all data from Tools class

	public PackageTools(panelDimension dimension, String string) {
		super(dimension,string);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		addNewButton(new Button(this, "Class 0"));//constucted new button and adds to parameters for method listed within this class
		this.setType("Package Tools");
	}

}

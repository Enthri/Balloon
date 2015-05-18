package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;

public class PackageTools extends Tools{

	public PackageTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new Button(this, "Class 0"));
		this.setType("Package Tools");
	}

}

package DragAndDrop;

import com.troi.balloon.Button;

import util.panelDimension;

public class PackageTools extends Tools{

	public PackageTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new Button(this));
		addNewButton(new Button(this));
	}

}

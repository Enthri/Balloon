package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Block;
import com.troi.balloon.Button;
import com.troi.balloon.ObjectBlock;

public class ClassTools extends Tools {

	public ClassTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new Button(this, "For  "));
		addNewButton(new Button(this, "If   "));
		addNewButton(new Button(this, "Test "));
		ObjectBlock Object = new ObjectBlock(this, "STring");
		Object.setText("Object");
		addNewButton(Object);
		this.setType("ClassTools");
	}



}

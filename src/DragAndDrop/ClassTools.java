package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Method1;
import com.troi.balloon.Method2;
import com.troi.balloon.ObjectBlock;
import com.troi.balloon.privateBlock;
import com.troi.balloon.publicBlock;
import com.troi.balloon.staticBlock;
import com.troi.balloon.voidBlock;

public class ClassTools extends Tools {

	public ClassTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new publicBlock(this));
		addNewButton(new privateBlock(this));
		addNewButton(new staticBlock(this));
		addNewButton(new Method1(this));
		addNewButton(new Method2(this));
		addNewButton(new voidBlock(this));
		addNewButton(new ObjectBlock(this));
		this.setType("ClassTools");
	}



}

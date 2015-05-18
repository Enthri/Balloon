package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Method1;
import com.troi.balloon.Method2;
import com.troi.balloon.ObjectBlock;
import com.troi.balloon.privateBlock;
import com.troi.balloon.publicBlock;
import com.troi.balloon.staticBlock;
import com.troi.balloon.voidBlock;

public class ClassTools extends Tools {//inheritos all data from Tools class

	public ClassTools(panelDimension dimension, String string) {
		super(dimension,string);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		addNewButton(new publicBlock(this));//constucted new button and adds to parameters for method listed within this class
		addNewButton(new privateBlock(this));
		addNewButton(new staticBlock(this));
		addNewButton(new Method1(this));
		addNewButton(new Method2(this));
		addNewButton(new voidBlock(this));
		addNewButton(new ObjectBlock(this));
		this.setType("ClassTools");
	}



}

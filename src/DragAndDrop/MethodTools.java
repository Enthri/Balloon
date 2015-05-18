package DragAndDrop;


import util.panelDimension;

import com.troi.balloon.ObjectBlock;
import com.troi.balloon.forBlock;
import com.troi.balloon.ifBlock;
import com.troi.balloon.intBlock;
import com.troi.balloon.stringBlock;
import com.troi.balloon.varBlock;
import com.troi.balloon.whileBlock;

public class MethodTools extends Tools{//inheritos all data from Tools class

	public MethodTools(panelDimension dimension, String string) {
		super(dimension,string);//feeding data from the constructer explicit parameters into the superconstructor class constructor
		addNewButton(new whileBlock(this));//constucted new button and adds to parameters for method listed within this class
		addNewButton(new forBlock(this));
		addNewButton(new ifBlock(this));
		addNewButton(new intBlock(this));
		addNewButton(new varBlock(this));
		addNewButton(new ObjectBlock(this));
		addNewButton(new stringBlock(this));
		this.setType("Method Tools");
	}

}

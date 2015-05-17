package DragAndDrop;

import com.troi.balloon.Button;
import util.panelDimension;

public class CommandTools extends Tools {

	public CommandTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new Button(this));
		this.setType("Command Tools");
	}

}

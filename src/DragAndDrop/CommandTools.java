package DragAndDrop;

import Buttons.NewCommandButton;
import util.panelDimension;

public class CommandTools extends Tools {

	public CommandTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new NewCommandButton(this, new CommandManager(dimension,string)));
		this.setType("Command Tools");
	}

}

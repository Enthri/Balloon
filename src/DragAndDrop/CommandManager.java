package DragAndDrop;

import com.troi.balloon.Button;
import com.troi.balloon.Panel;

import util.panelDimension;

public class CommandManager extends ObjectManager {

	public CommandManager(Panel container,panelDimension dimension, String state) {
		super(container,dimension, state);
		this.setType("Command Manager");
	}
	public void newPanel()
	{
		this.getPanels().add(new CommandManager(this,this.getDimension(),"MainViewer"));
	}

}
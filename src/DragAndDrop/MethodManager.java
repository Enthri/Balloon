package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Panel;

public class MethodManager extends ObjectManager{

	public MethodManager(Panel container,panelDimension dimension, String state) {
		super(container,dimension, state);
		this.setType("Method Manager");
	}
	public void newPanel()
	{
		this.getPanels().add(new CommandManager(this,this.getDimension(),"MainViewer"));
	}
}

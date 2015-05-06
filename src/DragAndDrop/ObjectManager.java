package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;
import com.troi.balloon.Panel;

public class ObjectManager extends Panel {
	protected String currentState;
	
	public ObjectManager(panelDimension dimension,String state) {
		super(dimension,state);
		this.currentState = state;
		this.addButton(new Button(this));
	}
	
	public String getState()
	{
		return currentState;
	}
	
	public void switchState(String state,panelDimension dimension)
	{
		currentState = state;
		this.setSize(dimension);
	}
	
}

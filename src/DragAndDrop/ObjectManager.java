package DragAndDrop;

import util.panelDimension;

import com.troi.balloon.Button;
import com.troi.balloon.Panel;

public class ObjectManager extends Panel {//inheritos all data from Panels class
	protected String currentState;
	
	public ObjectManager(Panel container,panelDimension dimension,String state) {
		super(container,dimension,state);
		this.currentState = state;
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
	public void adjustForType(String type)
	{
		if (type.equals("MainViewer"))
		{
			
		}
	}
	
}

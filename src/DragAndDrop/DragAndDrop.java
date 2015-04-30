package DragAndDrop;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.troi.balloon.Panel;
import com.troi.balloon.UiManager;


public class DragAndDrop{
	ArrayList<Panel> currentPanels = new ArrayList<Panel>();
	UiManager manager;
	JFrame frame;
	public DragAndDrop(JFrame frame, UiManager manager)
	{
		
		this.manager = manager;
		this.frame = frame;
	}
	
	public void addNewTool()
	{
		if (currentPanels.contains(new Object()) == true)
		{
			if (currentPanels.get(2) instanceof PackageManager)
			{
				currentPanels.set(1, new PackageTools(manager.getToolDimension()));
			}
			else if (currentPanels.get(2) instanceof ClassManager)
			{
				currentPanels.set(1, new ClassTools(manager.getToolDimension()));
			}
			else if (currentPanels.get(2) instanceof MethodManager)
			{
				currentPanels.set(1, new PackageTools(manager.getToolDimension()));
			}
			else if (currentPanels.get(2) instanceof CommandManager)
			{
				currentPanels.set(1, new PackageTools(manager.getToolDimension()));
			}
			else
			{
				currentPanels.set(1, new Panel());
			}
		}
	}
	
	public void addNewEditer()
	{
		if (currentPanels.contains(new Object()) == true)
		{
			if (currentPanels.get(0) instanceof PackageManager)
			{
				currentPanels.set(2, new PackageTools(manager.getMainDimension()));
				addNewTool();
			}
			else if (currentPanels.get(0) instanceof ClassManager)
			{
				currentPanels.set(2, new PackageTools(manager.getMainDimension()));
				addNewTool();
			}
			else if (currentPanels.get(0) instanceof MethodManager)
			{
				currentPanels.set(2, new PackageTools(manager.getMainDimension()));
				addNewTool();
			}
			else if (currentPanels.get(0) instanceof CommandManager)
			{
				currentPanels.set(2, new PackageTools(manager.getMainDimension()));
				addNewTool();
			}
			else
			{
				currentPanels.set(2, new Panel());
				addNewTool();
			}
		}
	}
	
	public void replaceCurrentTool()
	{
		
	}
	
	public void replaceCurrentEditer()
	{
		
	}
	
	public void removeCurrentTool()
	{
		
	}
	
	public void removeCurrentEditer()
	{
		
	}

}

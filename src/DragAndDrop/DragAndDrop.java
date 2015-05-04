package DragAndDrop;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JFrame;

import com.troi.balloon.Panel;
import com.troi.balloon.UiManager;


public class DragAndDrop{
	public TreeMap<String,Panel> map;
	public ArrayList<Panel> currentPanels = new ArrayList<Panel>();
	UiManager manager;
	JFrame frame;
	public DragAndDrop(JFrame frame, UiManager manager)
	{
		
		this.manager = manager;
		this.frame = frame;
		initializeEditer();
		System.out.println(currentPanels.get(2).getType());
	}
	
	public void initializeEditer()
	{
		currentPanels.add(new PackageManager(manager.getFileDimension(),"FileViewer"));
		currentPanels.add(new PackageTools(manager.getToolDimension()));
		currentPanels.add(new PackageManager(manager.getMainDimension(),"MainViewer"));
	}
	
	public TreeMap<String,Panel> setButtons()
	{
		
		map.put("FileManagerButtons", currentPanels.get(0));
		map.put("ToolManagerButtons", currentPanels.get(1));
		map.put("MainManagerButtons", currentPanels.get(2));
		return map;
	
	}
	public void addNewTool()
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
			currentPanels.set(1, new MethodTools(manager.getToolDimension()));
		}
		else if (currentPanels.get(2) instanceof CommandManager)
		{
			currentPanels.set(1, new CommandTools(manager.getToolDimension()));
		}
	
	}
	
	public void addNewEditer()
	{
		
		if (currentPanels.get(0) instanceof PackageManager)
		{
			currentPanels.set(2, new PackageManager(manager.getMainDimension(),"MainViewer"));
			addNewTool();
		}
		else if (currentPanels.get(0) instanceof ClassManager)
		{
			currentPanels.set(2, new MethodManager(manager.getMainDimension(),"MainViewer"));
			addNewTool();
		}
		else if (currentPanels.get(0) instanceof MethodManager)
		{
			currentPanels.set(2, new CommandManager(manager.getMainDimension(),"MainViewer"));
			addNewTool();
		}
		else
		{
			currentPanels.set(2, new Panel(manager.getToolDimension()));
			addNewTool();
		}
		
	}
	
	public void addNewFileManager()
	{

		if (currentPanels.get(2) instanceof PackageManager)
		{
			
		}
		else if (currentPanels.get(2) instanceof ClassManager)
		{
			currentPanels.set(1, new PackageManager(manager.getFileDimension(),"FileManager"));
		}
		else if (currentPanels.get(2) instanceof MethodManager)
		{
			currentPanels.set(1, new ClassManager(manager.getFileDimension(),"FileManager"));
		}
		else if (currentPanels.get(0) instanceof CommandManager)
		{
			currentPanels.set(1, new MethodManager(manager.getFileDimension(),"FileManager"));
		}
		else
		{
			currentPanels.set(2, new Panel(manager.getFileDimension()));
		}
	}
	
	public String getPanel(int index)
	{
		System.out.println("getPanel check");
		return currentPanels.get(index).getType();
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

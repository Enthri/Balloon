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
		initializeEditer();
		
	}
	
	public void initializeEditer()
	{
		currentPanels.add(new ClassManager(manager.getFileDimension(),"FileViewer"));
		currentPanels.add(new PackageTools(manager.getToolDimension(),"ToolViewer"));
		currentPanels.add(new PackageManager(manager.getMainDimension(),"MainViewer"));
	}
	public void addNewTool()
	{
		if (currentPanels.get(2) instanceof PackageManager)
		{
			currentPanels.set(1, new PackageTools(manager.getToolDimension(),"ToolViewer"));
		}
		else if (currentPanels.get(2) instanceof ClassManager)
		{
			currentPanels.set(1, new ClassTools(manager.getToolDimension(),"ToolViewer"));
		}
		else if (currentPanels.get(2) instanceof MethodManager)
		{
			currentPanels.set(1, new MethodTools(manager.getToolDimension(),"ToolViewer"));
		}
		else if (currentPanels.get(2) instanceof CommandManager)
		{
			currentPanels.set(1, new CommandTools(manager.getToolDimension(),"ToolViewer"));
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
			currentPanels.set(2, new PackageManager(manager.getToolDimension(),"MainViewer"));
			addNewTool();
		}
		
	}
	public ArrayList<Panel> getCurrentPanels()
	{
		return currentPanels;
	}
	public Panel getMainViewer()
	{
		return (Panel)currentPanels.get(2);
	}
	
	public Panel getToolViewer()
	{
		return currentPanels.get(1);
	}
	
	public Panel getFileViewer()
	{
		return currentPanels.get(0);
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
			currentPanels.set(2, new Panel(manager.getFileDimension(),"FileManager"));
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

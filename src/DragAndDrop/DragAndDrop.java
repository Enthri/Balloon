package DragAndDrop;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import com.troi.balloon.Panel;
import com.troi.balloon.UiManager;


public class DragAndDrop{
	public ArrayList<Panel> currentPanels = new ArrayList<Panel>();
	HashMap<String, Panel> Instances;
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
		
		currentPanels.add(new Settings(null,manager.getFileDimension(),"FileViewer"));
		currentPanels.add(new PackageTools(manager.getToolDimension(),"ToolViewer"));
		currentPanels.add(new PackageManager(null,manager.getMainDimension(),"MainViewer"));
	}
	
	public void changeEditer(Panel panel)
	{
			if (panel instanceof PackageManager)
			{
				currentPanels.set(2, panel);
				currentPanels.get(2).setSize(manager.getMainDimension());
				currentPanels.set(1, new PackageTools(manager.getToolDimension(),"ToolViewer"));
				currentPanels.set(0, new Settings(null,manager.getFileDimension(),"Settings"));
			}
			else if (panel instanceof ClassManager)
			{
				currentPanels.set(2, panel);
				currentPanels.get(2).setSize(manager.getMainDimension());
				currentPanels.set(1, new ClassTools(manager.getToolDimension(),"ToolViewer"));
				currentPanels.set(0, panel.stepUp());
				currentPanels.get(0).setSize(manager.getFileDimension());
			}
			else if (panel instanceof MethodManager)
			{
				currentPanels.set(2, panel);
				currentPanels.get(2).setSize(manager.getMainDimension());
				currentPanels.set(1, new MethodTools(manager.getToolDimension(),"ToolViewer"));
				currentPanels.set(0, panel.stepUp());
			}
			else if (panel instanceof CommandManager)
			{
				currentPanels.set(2, panel);
				currentPanels.get(2).setSize(manager.getMainDimension());
				currentPanels.set(1, new CommandTools(manager.getToolDimension(),"ToolViewer"));
				currentPanels.set(0, panel.stepUp());
			}
			else System.out.println("it's working");
			
	}
	
	public void changeTool (Panel panel)
	{
		currentPanels.set(1, panel);
	}
	
	public void changeFileViewer(Panel panel)
	{
		currentPanels.set(0,panel);
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
	
/*	public void addNewEditer()
	{
		if (currentPanels.get(0) instanceof ClassManager)
		{
			currentPanels.set(2, new MethodManager(manager.getMainDimension(),"MainViewer"));
			addNewTool();
		}
		else if (currentPanels.get(0) instanceof MethodManager)
		{
			currentPanels.set(2, new CommandManager(manager.getMainDimension(),"MainViewer"));
			addNewTool();
		}
		else if (currentPanels.get(0) instanceof PackageManager )
		{
			currentPanels.set(2, new ClassManager(manager.getToolDimension(),"MainViewer"));
			addNewTool();
		}
		
	}*/
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
	/*public void addNewFileManager()
	{
		 if (currentPanels.get(2) instanceof ClassManager)
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
		else System.out.println("no File manager matchable");
	}*/
	
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

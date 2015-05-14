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
		currentPanels.add(new PackageManager(manager.getFileDimension(),"FileViewer"));
		currentPanels.add(new ClassTools(manager.getToolDimension(),"ToolViewer"));
		
		currentPanels.add(new ClassManager(manager.getMainDimension(),"MainViewer"));
	}
	
	public void changeEditer(Panel panel)
	{
			currentPanels.set(2, panel);
			currentPanels.get(2).setSize(manager.getMainDimension());
			currentPanels.get(2).resetButtonLocation();
			currentPanels.get(2).setType("MainViewer");

			currentPanels.set(1, new ClassTools(manager.getToolDimension(),"ToolViewer"));
			currentPanels.set(0, new PackageManager(manager.getFileDimension(), "FileViewer"));
			System.out.println("it's working");
			
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
	
	public void addNewEditer()
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

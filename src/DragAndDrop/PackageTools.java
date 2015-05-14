package DragAndDrop;

import util.panelDimension;
import Buttons.NewPackageButton;

public class PackageTools extends Tools{

	public PackageTools(panelDimension dimension, String string) {
		super(dimension,string);
		addNewButton(new NewPackageButton(this,new PackageManager(dimension,string)));
	}

}

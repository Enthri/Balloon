package Buttons;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import util.panelDimension;

import com.troi.balloon.Button;
import com.troi.balloon.Panel;
//buttons list:
//	class button
//	package button -- X
//	method button
//	command button
//	tools button
public class PackageButton extends Button {
	public PackageButton(Panel container,Panel pointTo) {
		super(container,pointTo);
	}
	
}

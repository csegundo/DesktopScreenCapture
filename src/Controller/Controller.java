package Controller;

import javax.swing.JFrame;

public abstract class Controller {
	
	private static Controller _instance;
	
	public static Controller getInstance() {
		if(_instance == null)
			_instance = new ControllerImplementation();
		
		return _instance;
	}
	
	public abstract void makeScreenshot(JFrame father);
}

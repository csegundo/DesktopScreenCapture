package Controller;

import javax.swing.JFrame;

import View.MakeCapture;

public class ControllerImplementation extends Controller {

	@Override
	public void makeScreenshot(JFrame father) {
		new MakeCapture(father);
		System.exit(0);
	}

}

package View;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

// Makes a screenshot and save it where the user wants.
public class MakeCapture {
	
	private Robot _screen;
	private JFileChooser _chooser;
	
	public MakeCapture(JFrame father) {
		makeCapture(father);
	}
	
	private void makeCapture(JFrame father) {
		try {
			Thread.sleep(500);
			_screen = new Robot();
			BufferedImage capture = _screen.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			savePicture(father, capture);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something was wrong...", "Unexpected exception.", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void savePicture(JFrame father, BufferedImage capture) throws Exception {
		FileNameExtensionFilter filterPNG = new FileNameExtensionFilter("PNG image", "png");
		_chooser = new JFileChooser();
		
		_chooser.setDialogTitle("Save image as...");
		_chooser.setFileFilter(filterPNG);
		_chooser.addChoosableFileFilter(filterPNG);
		
		if (_chooser.showSaveDialog(father) == JFileChooser.APPROVE_OPTION) {
			String path = _chooser.getSelectedFile().getAbsolutePath();
			
			if (new File((path + ".png")).exists()) {
				if (JOptionPane.showConfirmDialog(null, "File \"" + (path + ".png") + "\" already exists." 
						+ '\n' + "Do you want to overwrite?") == JOptionPane.OK_OPTION) {
					File output = new File(path + ".png");
					ImageIO.write(capture, "png", output);
				}
			}
			else {
				File output = new File(path + ".png");
				ImageIO.write(capture, "png", output);
			}
		}
	}

}

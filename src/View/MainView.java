package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainView extends JFrame {
	
	private JButton _capture;
	private JButton _exit;
	
	public MainView() {
		initGUI();
	}

	private void initGUI() {
		try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception ex){
        	System.err.println("Something was wrong...");
        }
		this.setSize(130, 40);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Desktop Screen Capture");
		this.setResizable(false);
		this.setUndecorated(true);
		
		captureButtonAction();
		exitButtonAction();
		
		this.setVisible(true);
		
		this.setIconImage(new ImageIcon("resources/icons/icon.png").getImage());
	}

	private void captureButtonAction() {
		_capture = new JButton();
		_capture.setIcon(new ImageIcon("resources/icons/icon.png"));
		_capture.setToolTipText("Click me!");
		_capture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				Controller.Controller.getInstance().makeScreenshot(MainView.this);
			}
		});
		this.add(_capture);
	}
	
	private void exitButtonAction() {
		_exit = new JButton();
		_exit.setIcon(new ImageIcon("resources/icons/exit.png"));
		_exit.setToolTipText("Exit.");
		_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		this.add(_exit);
	}

}

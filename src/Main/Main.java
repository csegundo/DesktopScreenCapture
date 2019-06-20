package Main;

import javax.swing.SwingUtilities;

import View.MainView;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				@SuppressWarnings("unused")
				MainView frame = new MainView();
			}
		});
	}

}

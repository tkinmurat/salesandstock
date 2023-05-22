package tr.com.muratproje.test;

import javax.swing.SwingUtilities;

import tr.com.muratproje.frontend.LoginFE;
import tr.com.muratproje.frontend.MainWindowFE;

public class Run {

	public static void main(String[] args) {
		

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				//new MainWindowFE();
				new LoginFE();
				
			}
		});;

	}

}

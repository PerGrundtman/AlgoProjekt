package application;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * Main class
 * @author Per
 */
public class Start {
	private final static int guiHeight = 500;
	private final static int guiWidth = 800;

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame mainframe = new JFrame("Smallest Enclosing Disc");
				mainframe.add(new GUI());
				mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainframe.setSize(guiWidth, guiHeight);
				mainframe.setVisible(true);
				
			}
		});
	}
}

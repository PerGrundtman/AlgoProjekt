package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import math.RandomGen;
/**
 * Initializes and displays the GUI
 * @author Per
 */
public class GUI extends JPanel{

	/*
 	coordinate ranges for the canvas 
	250 < x < 780
	1 < y < 450
	 */
	
	private final int canvasXmin = 250;
	private final int canvasXmax = 780;
	private final int canvasYmin = 1;
	private final int canvasYmax = 450;

	private int mouseX;
	private int mouseY;
	private final int dotSize = 6;

	/* input-points */
	public ArrayList<Point> inputPoints = new ArrayList<Point>();

	private JPanel buttonPanel;
	private JButton compute;
	private JTextField numbOfPoints;
	private JButton generatePoints;
	private JButton storePointSet;
	private JButton clearScreen;
	private JButton simulate; //TODO: simulate the algorithm...
	private static int inputNumber;
/*
 * default constructor
 */
	public GUI() {
		displayGUI();

		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				inputPoints.add(createPoint(mouseX, mouseY));

				System.out.println(mouseX + " " + mouseY);
				repaint();

			}
		});
	}

	public void displayGUI(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		initControls();	
	}
	public void initControls(){
		setBackground(Color.darkGray);
		buttonPanel = new JPanel();
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.WEST);
		final JPanel genPanel = new JPanel();


		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setBackground(Color.magenta);

		/*
		 * Init swing components
		 */
		compute = new JButton("Compute MEC");
		buttonPanel.add(compute);
		storePointSet = new JButton("Store point-set");
		buttonPanel.add(storePointSet);
		clearScreen = new JButton("Clear");
		buttonPanel.add(clearScreen);
		generatePoints = new JButton("Generate random points");
		numbOfPoints = new JTextField(5);
		genPanel.setLayout(new FlowLayout());
		genPanel.add(generatePoints);
		genPanel.add(numbOfPoints);
		buttonPanel.add(genPanel);

		/*
		 * Generate random-set of points of a chosen size 
		 */
		generatePoints.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(numbOfPoints.getText().length()==0){

					JOptionPane.showMessageDialog(genPanel, "Hey Chips! Enter a number in the textfield and try again :) ");
				} else {

					inputNumber = Integer.parseInt(numbOfPoints.getText());
					RandomGen rngX = new RandomGen();
					RandomGen rngY = new RandomGen();

					for (int i=0; i<inputNumber;i++){

						int randX = rngX.nextIntInRange(canvasXmin, canvasXmax);
						int randY = rngY.nextIntInRange(canvasYmin, canvasYmax); 
						inputPoints.add(new Point(randX, randY));
					}
					repaint();
					numbOfPoints.setText("");
					System.out.println(inputPoints.size());
				}
			}
		});
		clearScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputPoints.clear();
				inputNumber = 0;
				repaint();
			}
		});


	}

	/*creates a 2-dimensional point*/
	public Point createPoint(int x, int y){Point point = new Point(x, y);return point;}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.green);
		for (Point point: inputPoints){
			g.fillRect(point.x, point.y, dotSize, dotSize);

		}
	};
}

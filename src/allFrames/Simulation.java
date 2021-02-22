package allFrames;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

//1. START HERE: This is the frame that displays the starting screen and the instructions for the simulation
public class Simulation {
	
	private JFrame frmLifeOfA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulation window = new Simulation();
					window.frmLifeOfA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public Simulation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLifeOfA = new JFrame();
		frmLifeOfA.setTitle("Life of a Computer Scientist");
		frmLifeOfA.setSize(472, 296);
		frmLifeOfA.setLocationRelativeTo(null);
		frmLifeOfA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting up main JPanel and GridBagLayout
		JPanel starting = new JPanel();
		starting.setBackground(new Color(230, 230, 250));
		frmLifeOfA.getContentPane().add(starting, BorderLayout.CENTER);
		GridBagLayout gbl_starting = new GridBagLayout();
		gbl_starting.columnWidths = new int[] {50, 375, 50};
		gbl_starting.rowHeights = new int[]{30, 50, 35, 29, 29, 0};
		gbl_starting.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_starting.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		starting.setLayout(gbl_starting);
		
		//Introduction to game
		JLabel introLabel = new JLabel("<html><p>Welcome! This is a 5 year simulation game. Try to keep your characters from getting fired!<p><html>");
		GridBagConstraints gbc_introLabel = new GridBagConstraints();
		gbc_introLabel.fill = GridBagConstraints.BOTH;
		gbc_introLabel.insets = new Insets(0, 0, 5, 0);
		gbc_introLabel.gridx = 1;
		gbc_introLabel.gridy = 1;
		starting.add(introLabel, gbc_introLabel);
		
		//Button to start game
		JButton startGame = new JButton("Start");
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputPlayer nw = new inputPlayer();
				nw.inputScreen();
				frmLifeOfA.dispose();
				JFrame frame = new JFrame();
			}
		});
		
		
		GridBagConstraints gbc_startGame = new GridBagConstraints();
		gbc_startGame.insets = new Insets(0, 0, 5, 0);
		gbc_startGame.gridx = 1;
		gbc_startGame.gridy = 3;
		starting.add(startGame, gbc_startGame);
		
		//Popup menu with instruction when button is pressed
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setToolTipText("");
		popupMenu.setLabel("");
		
		JButton instructButton = new JButton("Instructions");
		instructButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(instructButton, instructButton.getBounds().x-120, instructButton.getBounds().y-120);
			}
		});
		
		//Text Instructions that appear in the PopUpMenu
		JTextArea txtrHowToPlay = new JTextArea();
		txtrHowToPlay.setEditable(false);
		txtrHowToPlay.setText("How to Play: This simulation represents an \noffice environment. Each employee works in \nthe Computer Science space and is trying to survive. \nTo do so, they must show up to work on time, \ntrain in different languages and apply for jobs. \nAfter creating your characters at the beginning, \nyou will be able to make some more changes/\nchoices after every \"year\". There are 5 years in total. \nGood luck!");
		txtrHowToPlay.setColumns(20);
		txtrHowToPlay.setRows(8);
		popupMenu.add(txtrHowToPlay);
		GridBagConstraints gbc_instructButton = new GridBagConstraints();
		gbc_instructButton.gridx = 1;
		gbc_instructButton.gridy = 4;
		starting.add(instructButton, gbc_instructButton);
	}
}
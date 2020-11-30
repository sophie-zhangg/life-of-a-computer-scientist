package allFrames;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;

//3. This is the frame that displays the stats of the employees every year. Another frame displays the text output of each of the behaviors
public class FiveYears {

	//Initialized Variables
	private JFrame frame;
	private JFrame frm;
	private JPopupMenu popupMenu = new JPopupMenu();
	public ArrayList<ComputerScientist> employees = inputPlayer.employees;
	public int numOfEmploy=inputPlayer.numOfEmploy;
	private int year=0;
	public ArrayList<JLabel> employeesLbl = new ArrayList<JLabel>();
	public GridBagConstraints employeesConstraints[]= new GridBagConstraints[employees.size()];
	public JMenu menuEmploy[]=new JMenu[employees.size()];
	public int index=-1;
	public JTextArea txtr;
	
	/**
	 * Launch the application.
	 */
	public void years() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiveYears window = new FiveYears();
					window.frm.setVisible(true);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FiveYears() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Setting up first JFrame with employee stats
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		//Setting up main JPanel and GridBagLayout
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{55, 191, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		//Setting up Menu to Select Behaviors
		JMenu train=new JMenu("Train in New Language");
		JMenuItem java=new JMenuItem("Java");
		train.add(java);
		JMenuItem python=new JMenuItem("Python");
		train.add(python);
		JMenuItem c=new JMenuItem("C");
		train.add(c);
		JMenuItem cPlusPlus=new JMenuItem("C++");
		train.add(cPlusPlus);
		JMenuItem html=new JMenuItem("HTML");
		train.add(html);
		JMenuItem javaScript=new JMenuItem("JavaScript");
		train.add(javaScript);
		JMenuItem sql=new JMenuItem("SQL");
		train.add(sql);
		JMenuItem swift=new JMenuItem("Swift");
		train.add(swift);
		
		JMenu apply=new JMenu("Apply for Promotion");
		JMenuItem manage=new JMenuItem("Manager");
		apply.add(manage);
		JMenuItem cio=new JMenuItem("CIO");
		apply.add(cio);
		
		JMenu vacay=new JMenu("Take Vacation");
		JLabel lblNewLabel = new JLabel("Number of Weeks (Max 5)");
		vacay.add(lblNewLabel);
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 5, 1));
		vacay.add(spinner);
		JButton button = new JButton("Enter");
		vacay.add(button);
		
		JMenuItem quit=new JMenuItem("Quit Job");
		//Adding menus in PopUpMenu
		popupMenu.add(train);
		popupMenu.add(apply);
		popupMenu.add(vacay);
		popupMenu.add(quit);
		
		year++;
		frame.setTitle("Year "+Integer.toString(year));
		
		JLabel lblNewLabel1 = new JLabel("Right Click Employee for Behaviours");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel1, gbc_lblNewLabel);
		
		//Setting up Text Area w/ String output
		frm = new JFrame();
		frm.setTitle("Updates");
		frm.setBounds(800, 100, 550, 300);
		
		txtr = new JTextArea("");
		txtr.setEditable(false);
		txtr.setLineWrap(true);
        txtr.setWrapStyleWord(true);
		txtr.setVisible(true);
		
		JScrollPane scrollPaneText = new JScrollPane(txtr);
		scrollPaneText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneText.setPreferredSize(new Dimension(550, 300));
		frm.add(scrollPaneText, BorderLayout.CENTER);
		
		//First year setting up employee stats
		for (int i=0; i<employees.size(); i++) {
			(employees.get(i)).worked(261);
			employeesLbl.add(new JLabel("<html>"+employees.get(i).getName()+": "+employees.get(i).getTitle()+"<br>Total Money Earned: $"+employees.get(i).getMoneyEarned()+" <br>Happiness Level: "+employees.get(i).getHappiness()+"/10<html>"));
			employeesConstraints[i]=new GridBagConstraints();
			employeesConstraints[i].insets = new Insets(0, 0, 5, 0);
			employeesConstraints[i].gridx = 0;
			employeesConstraints[i].gridy = i+1;
			panel.add(employeesLbl.get(i), employeesConstraints[i]);
			//If employee label clicked then,
			employeesLbl.get(i).addMouseListener(new MouseAdapter() 
			{  
				public void mousePressed(MouseEvent e) {
					Object source = e.getSource();
				    for (int in = 0; in < employeesLbl.size(); in++) {
				        if (employeesLbl.get(in).equals(source)) {
				            index = in;
				            showPopup(e);
				            break;
				        }
				    }
				} 
			});
		}
		
	//Action Listeners for menu
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Appending output to text area
				txtr.append(employees.get(index).takeBreak((int) spinner.getValue())+"\n");
				spinner.setValue(0);
			}
		});
	    learnedLang(java);
	    learnedLang(python);
	    learnedLang(c);
	    learnedLang(cPlusPlus);
	    learnedLang(html);
	    learnedLang(javaScript);
	    learnedLang(sql);
	    learnedLang(swift);
	    applied(manage);
	    applied(cio);
	    
	    quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtr.append(employees.get(index).fired(employees.get(index).getTitle(),employees.get(index).getCompany())+"\n");
			}
		});
		
	    //Second year to fifth year
		JButton nextButton = new JButton("Next Year");
		nextButton.setToolTipText((year+1)+"/5");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = employees.size()+1;
		panel.add(nextButton, gbc_button);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year++;
				for (int i=0; i<employees.size(); i++) {
					panel.remove(employeesLbl.get(i));
					if (employees.get(i).getHappiness()<5) {
						employees.get(i).fired(employees.get(i).getTitle(), employees.get(i).getCompany());
						txtr.append(employees.get(i).getName()+" was too unhappy and quit.\n");
					}
					if (employees.get(i).getTitle().equals("Unemployed")) {
						employeesLbl.set(i,new JLabel("<html>"+employees.get(i).getName()+": <font color=#FF0000>"+employees.get(i).getTitle()+"<font color=#000000><br>Money Earned: $"+employees.get(i).getMoneyEarned()+" <br>Happiness Level: "+employees.get(i).getHappiness()+"/10<html>"));
					}
					else {
						(employees.get(i)).worked(261);
						employeesLbl.set(i,new JLabel("<html>"+employees.get(i).getName()+": "+employees.get(i).getTitle()+"<br>Money Earned: $"+employees.get(i).getMoneyEarned()+" <br>Happiness Level: "+employees.get(i).getHappiness()+"/10<html>"));
					}
					panel.add(employeesLbl.get(i), employeesConstraints[i]);
					employeesLbl.get(i).addMouseListener(new MouseAdapter() 
					{  
						public void mousePressed(MouseEvent e) {
							Object source = e.getSource();
						    for (int in = 0; in < employeesLbl.size(); in++) {
						        if (employeesLbl.get(in).equals(source) && employees.get(in).getTitle().equals("Unemployed")==false) {
						            index = in;
						            showPopup(e);
						            break;
						        }
						    }
						} 
					});
				}
				//If last year, button title is "End Simulation"
				if (year==5){
					nextButton.setText("End Simulation");
				}
				//If past fifth year, exit program
				else if (year>5){
					System.exit(0);
				}
				panel.revalidate();
				panel.repaint();
				frame.setTitle("Year "+Integer.toString(year));
			}
		});

	}
	//Show the PopUpMenu method
	private void showPopup(MouseEvent me) {
	      if(me.isPopupTrigger())
	         popupMenu.show(me.getComponent(), me.getX(), me.getY());
	   }

//Methods for menu options
	private void learnedLang(JMenuItem item) {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtr.append(employees.get(index).trained(item.getText())+"\n");
			}
		});
	}
	
	private void applied(JMenuItem item) {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtr.append(employees.get(index).promoted(item.getName(),year,employees.get(index).getKnownLang())+"\n");
			}
		});
	}

}

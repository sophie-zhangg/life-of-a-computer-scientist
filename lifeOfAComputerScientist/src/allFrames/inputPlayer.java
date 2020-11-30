package allFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import java.awt.Panel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//2. This is the frame that displays the inputting screen for each separate employee
public class inputPlayer {
	
	//Initialize Variables
	private JFrame frmInputComputerScientist;
	private JTextField textField;
	private JTextField textField_1;
	private int tabIndex=0;
	public static ArrayList<ComputerScientist> employees = new ArrayList<ComputerScientist>();
	private ArrayList<JLabel> displayNames = new ArrayList<JLabel>();
	int x =0;
	int y=0;
	
	public static int numOfEmploy=0;
	
	/**
	 * Launch the application.
	 */
	public void inputScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inputPlayer window = new inputPlayer();
					window.frmInputComputerScientist.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inputPlayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmInputComputerScientist = new JFrame();
		frmInputComputerScientist.getContentPane().setBackground(new Color(255, 250, 205));
		frmInputComputerScientist.setTitle("Life of a Computer Scientist: Input Computer Scientist");
		frmInputComputerScientist.setBounds(250, 100, 1000, 428);
		frmInputComputerScientist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Two tabs, one for input and one for list of current employees
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		frmInputComputerScientist.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            tabIndex=tabbedPane.getSelectedIndex();
	            if (tabIndex==0) {
	            	frmInputComputerScientist.setBounds(250, 100, 1000, 428);
	            }
	            else {
	            	frmInputComputerScientist.setBounds(250, 100, 400, 428);
	            }
	        }
	    });
		
		//Setting up main JPanel and GridBagLayout
		JPanel input = new JPanel();
		tabbedPane.addTab("Input New Employee", null, input, null);
		input.setBackground(new Color(240, 248, 255));
		GridBagLayout gbl_input = new GridBagLayout();
		gbl_input.columnWidths = new int[]{53, 0, 0, 0, 0, 120, 87, 0, 0};
		gbl_input.rowHeights = new int[]{56, 37, 114, 0, 0};
		gbl_input.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_input.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		input.setLayout(gbl_input);
		
		JLabel lblNewLabel = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		input.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		input.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblOfHours = new JLabel("<html># of Hours <br> in Workday<html>");
		GridBagConstraints gbc_lblOfHours = new GridBagConstraints();
		gbc_lblOfHours.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfHours.gridx = 3;
		gbc_lblOfHours.gridy = 1;
		input.add(lblOfHours, gbc_lblOfHours);
		
		JLabel lblCompany = new JLabel("Company");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 4;
		gbc_lblCompany.gridy = 1;
		input.add(lblCompany, gbc_lblCompany);
		
		JLabel lblFluentLanguages = new JLabel("Fluent Languages");
		GridBagConstraints gbc_lblFluentLanguages = new GridBagConstraints();
		gbc_lblFluentLanguages.insets = new Insets(0, 0, 5, 5);
		gbc_lblFluentLanguages.gridx = 5;
		gbc_lblFluentLanguages.gridy = 1;
		input.add(lblFluentLanguages, gbc_lblFluentLanguages);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Add to List <br>of Employees<html>");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 1;
		input.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		input.add(textField, gbc_textField);
		textField.setColumns(5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(5);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<html><font color=#566573>-- Select One --<html>", "Programmer", "Web Developer", "Software Engineer", "System Engineer", "IT Professional", "Manager", "CIO"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		input.add(comboBox, gbc_comboBox);
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(4);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setValue(8);
		slider.setMaximum(12);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 3;
		gbc_slider.gridy = 2;
		input.add(slider, gbc_slider);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 2;
		input.add(textField_1, gbc_textField_1);
		textField_1.setColumns(5);
		
		Panel panel = new Panel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 5;
		gbc_panel.gridy = 2;
		input.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{57, 0, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JCheckBox [] checkBoxes = new JCheckBox [8];
		
		checkBoxes[0] = new JCheckBox("Java");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox.gridx = 0;
		gbc_checkBox.gridy = 0;
		panel.add(checkBoxes[0], gbc_checkBox);
		
		checkBoxes[1] = new JCheckBox("Python");
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_1.gridx = 1;
		gbc_checkBox_1.gridy = 0;
		panel.add(checkBoxes[1], gbc_checkBox_1);
		
		checkBoxes[2] = new JCheckBox("C");
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_2.gridx = 0;
		gbc_checkBox_2.gridy = 1;
		panel.add(checkBoxes[2], gbc_checkBox_2);
		
		checkBoxes[3] = new JCheckBox("C++");
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBox_3.gridx = 1;
		gbc_checkBox_3.gridy = 1;
		panel.add(checkBoxes[3], gbc_checkBox_3);
		
		checkBoxes[4] = new JCheckBox("HTML");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 2;
		panel.add(checkBoxes[4], gbc_chckbxNewCheckBox);
		
		checkBoxes[5] = new JCheckBox("JavaScript");
		GridBagConstraints gbc_chckbxJavascript = new GridBagConstraints();
		gbc_chckbxJavascript.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxJavascript.gridx = 1;
		gbc_chckbxJavascript.gridy = 2;
		panel.add(checkBoxes[5], gbc_chckbxJavascript);
		
		checkBoxes[6] = new JCheckBox("SQL");
		GridBagConstraints gbc_chckbxSql = new GridBagConstraints();
		gbc_chckbxSql.anchor = GridBagConstraints.WEST;
		gbc_chckbxSql.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSql.gridx = 0;
		gbc_chckbxSql.gridy = 3;
		panel.add(checkBoxes[6], gbc_chckbxSql);
		
		checkBoxes[7] = new JCheckBox("Swift");
		GridBagConstraints gbc_chckbxSwift = new GridBagConstraints();
		gbc_chckbxSwift.anchor = GridBagConstraints.WEST;
		gbc_chckbxSwift.gridx = 1;
		gbc_chckbxSwift.gridy = 3;
		panel.add(checkBoxes[7], gbc_chckbxSwift);
		
		JButton button = new JButton("+");
		button.setToolTipText("Will Add to Table in 2nd Tab");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 2;
		input.add(button, gbc_button);
		
		JLabel lblError = new JLabel("<html><font color=#FF0000>ERROR: Select a Job Title<html>");
		lblError.setVisible(false);
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 3;
		input.add(lblError, gbc_lblError);
		
		JPanel aTable = new JPanel();
		aTable.setBackground(new Color(255, 250, 240));
		tabbedPane.addTab("View All Employees", null, aTable, null);
		GridBagLayout gbl_aTable = new GridBagLayout();
		gbl_aTable.columnWidths = new int[]{222, 0};
		gbl_aTable.rowHeights = new int[]{0, 16, 0};
		gbl_aTable.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_aTable.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		aTable.setLayout(gbl_aTable);
		
		JLabel lblNamesOfThe = new JLabel("Names of the Current Employees");
		GridBagConstraints gbc_lblNamesOfThe = new GridBagConstraints();
		gbc_lblNamesOfThe.anchor = GridBagConstraints.NORTH;
		gbc_lblNamesOfThe.insets = new Insets(0, 0, 5, 0);
		gbc_lblNamesOfThe.gridx = 0;
		gbc_lblNamesOfThe.gridy = 0;
		aTable.add(lblNamesOfThe, gbc_lblNamesOfThe);
		
		JPanel theNames = new JPanel();
		theNames.setBackground(new Color(255, 250, 240));
		GridBagConstraints gbc_theNames = new GridBagConstraints();
		gbc_theNames.fill = GridBagConstraints.VERTICAL;
		gbc_theNames.gridx = 0;
		gbc_theNames.gridy = 1;
		aTable.add(theNames, gbc_theNames);
		theNames.setLayout(new BoxLayout(theNames, BoxLayout.Y_AXIS));

		//Action listener to add employee to ArrayList
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex()==0) {
					lblError.setVisible(true);
				}
				else {
					lblError.setVisible(false);
					employees.add(new ComputerScientist(textField.getText(),comboBox.getSelectedItem().toString(),slider.getValue(),textField_1.getText(),getLangSelect(checkBoxes)));
					numOfEmploy++;
					displayNames.add(new JLabel(textField.getText()));
					addToTable(displayNames,numOfEmploy-1, theNames);
					aTable.revalidate();
					cleanUp(textField, comboBox, slider, textField_1, checkBoxes);
				}
			}
		});
		
		JButton btnStartSimulation = new JButton("Start Simulation");
		GridBagConstraints gbc_btnStartSimulation = new GridBagConstraints();
		gbc_btnStartSimulation.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartSimulation.gridx = 6;
		gbc_btnStartSimulation.gridy = 3;
		input.add(btnStartSimulation, gbc_btnStartSimulation);
		
		//Action listener to start simulation
		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiveYears five = new FiveYears();
				five.years();
				frmInputComputerScientist.dispose();
				JFrame anotherFrame = new JFrame();
			}
		});
	}
	
	//Method to erase all the input after add button is pressed
	private static void cleanUp(JTextField field,JComboBox combo, JSlider slide, JTextField field2, JCheckBox[] checks) {
		field.setText("");
		combo.setSelectedIndex(0);
		slide.setValue(8);
		field2.setText("");
		for (int i=0; i<checks.length; i++) {
			checks[i].setSelected(false);
		}
	}
	//To get all the languages added already
	private static ArrayList<String> getLangSelect(JCheckBox langs[]) {
		ArrayList<String> names = new ArrayList<String>();
		for (JCheckBox elem:langs) {
			if (elem.isSelected()) {
				names.add(elem.getText());
			}
		}
		return names;
	}
	
	//Add JLabel to JLabel ArrayList in the second tab 
	private static void addToTable(ArrayList<JLabel> names, int index, JPanel panel) {
		JLabel newName=names.get(index);
		panel.add(newName);
	}
		
}

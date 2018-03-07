/**
 * gui
 * 
 * @author Fasil Ayenew
 */
package gui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import backend.CFL;
import backend.GlassFiber;
import backend.Glazed;
import backend.Halogen;
import backend.LED;
import backend.MineralWool;
import backend.Project;
import backend.SprayFoam;
import backend.Thermal;
import backend.TriplePane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
/**
 * Introduction class for ui
 * 
 * @author Fasil Ayenew
 */
public class Intro {
	
	JFrame frame;
	ImageIcon img;
	ImageIcon img2;
	JLabel imgput;
	JFrame aboutFrame;
	int option;
	int backOption;
	JTextField textField;
	JTextField textField2;
	JTextArea textArea;
	String strTextField;
	double intTextField;
	int totalAmount;
	int totalAmount2;
	float price;
	Project myList;
	Project myNewList;
	String finale;
	//JFrame frame;
	//JFrame aboutFrame;
	int userOption;
	LED LedOption = new LED(0);
	CFL CflOption = new CFL(0);
	Halogen hlgOption = new Halogen(0);
	MineralWool mwOption = new MineralWool(0,0);
	GlassFiber gfOption = new GlassFiber(0,0);
	SprayFoam sfOption = new SprayFoam(0,0);
	Glazed glzOPtion = new Glazed(0,0);
	Thermal thOption = new Thermal(0,0);
	TriplePane tpOption = new TriplePane(0,0);
	String optionChoice1;
	String optionChoice2;
	String optionChoice3;
	float priceChoice1;
	float priceChoice2;
	float priceChoice3;
	String replace = "xxxx";
	boolean isNew = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro window = new Intro();
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
	public Intro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		img = new ImageIcon(getClass().getResource("diynrg.png"));
		JLabel lblNewLabel = new JLabel(img);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		img2 = new ImageIcon(getClass().getResource("fkmdmotto.png"));
		JLabel lblNewLabel2 = new JLabel(img2);
		frame.getContentPane().add(lblNewLabel2, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Start");
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StartPage nxt = new StartPage();
				frame.setVisible(false);
				nxt.frame.setVisible(true);
			}
		});
		
	}
	
	/**
	 * Starting class, user chooses prefered home improvement
	 * 
	 * @author Fasil Ayenew
	 */
	public class StartPage {

		JFrame frame;
		JFrame aboutFrame;
		int option;
		int backOption;

		/**
		 * Create the application.
		 */
		public StartPage() {
			initialize();
			if(isNew){
				myList = new Project("Projet 1");
			}
			
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 549);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel label = new JLabel("");
			label.setBounds(156, 11, 46, 14);
			frame.getContentPane().add(label);
			
			JLabel lblSelectDiyProject = new JLabel("Select DIY Project");
			lblSelectDiyProject.setBounds(166, 22, 111, 14);
			frame.getContentPane().add(lblSelectDiyProject);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Change bulbs");
			rdbtnNewRadioButton.setBounds(20, 94, 109, 23);
			frame.getContentPane().add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Replace insulation");
			rdbtnNewRadioButton_1.setBounds(20, 169, 138, 23);
			frame.getContentPane().add(rdbtnNewRadioButton_1);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Change windows");
			rdbtnNewRadioButton_2.setBounds(20, 246, 125, 23);
			frame.getContentPane().add(rdbtnNewRadioButton_2);
			
			/*if (rdbtnNewRadioButton.isSelected()){
				option = 1;
			}
			if (rdbtnNewRadioButton_1.isSelected()){
				option = 2;
			}
			if (rdbtnNewRadioButton_2.isSelected()){
				option = 3;
			}
			*/
			
			JButton btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//page1
					
					if (rdbtnNewRadioButton.isSelected()){
						OptionPage nxt = new OptionPage(1);
						frame.setVisible(false);
						backOption = 1;
						
						nxt.frame.setVisible(true);
						
					}
					if (rdbtnNewRadioButton_1.isSelected()){
						OptionPage nxt = new OptionPage(2);
						frame.setVisible(false);
						backOption = 2;
						
						nxt.frame.setVisible(true);
					}
					if (rdbtnNewRadioButton_2.isSelected()){
						OptionPage nxt = new OptionPage(3);
						frame.setVisible(false);
						backOption = 3;
						
						nxt.frame.setVisible(true);
					}
					
					
					
				}
			});
			
			btnNext.setBounds(322, 452, 89, 23);
			frame.getContentPane().add(btnNext);
			
			JButton btnSavedProjects = new JButton("Saved Projects");
			btnSavedProjects.setBounds(166, 364, 125, 23);
			frame.getContentPane().add(btnSavedProjects);
			
			//ImageIcon icon = new ImageIcon("diynrg.png");
			JButton btnHome = new JButton("Home");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Intro back =  new Intro();
					frame.setVisible(false);
					back.frame.setVisible(true);
					
				}
			});
			btnHome.setBounds(166, 452, 89, 23);
			frame.getContentPane().add(btnHome);
			
			JButton btnAbout = new JButton("?"); //about
			btnAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AboutPage about = new AboutPage();
					about.aboutFrame.setVisible(true);
					
					
				}
			});
			btnAbout.setBounds(365, 11, 46, 25);
			frame.getContentPane().add(btnAbout);
			
		}
	}
	
	/**
	 * Option class, user chooses option based on chosen home improvement
	 * 
	 * @author Fasil Ayenew
	 */
	public class OptionPage {

		JFrame frame;
		JFrame aboutFrame;
		int userOption;
		LED LedOption = new LED(0);
		CFL CflOption = new CFL(0);
		Halogen hlgOption = new Halogen(0);
		MineralWool mwOption = new MineralWool(0,0);
		GlassFiber gfOption = new GlassFiber(0,0);
		SprayFoam sfOption = new SprayFoam(0,0);
		Glazed glzOPtion = new Glazed(0,0);
		Thermal thOption = new Thermal(0,0);
		TriplePane tpOption = new TriplePane(0,0);
		String optionChoice1;
		String optionChoice2;
		String optionChoice3;
		float priceChoice1;
		float priceChoice2;
		float priceChoice3;
		String replace = "xxxx";
		

		public OptionPage(int op) {
			
			userOption = op;
			initialize();
		}
		//public OptionPage(){ //back method
			//initialize();
		//}
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 549);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			
			JLabel lblSelectDiyProject = new JLabel("Options");
			lblSelectDiyProject.setBounds(166, 22, 111, 14);
			frame.getContentPane().add(lblSelectDiyProject);
			
			
			if (userOption == 1){//bulbs
				optionChoice1 = LedOption.name();
				optionChoice2 = CflOption.name();
				optionChoice3 = hlgOption.name();
				priceChoice1 = LedOption.getLEDcost();
				priceChoice2 = CflOption.getCFLcost();
				priceChoice3 = hlgOption.getHalogenCost();
				
				
			}
			if (userOption == 2){//insulation
				optionChoice1 = mwOption.name();
				optionChoice2 = gfOption.name();
				optionChoice3 = sfOption.name();
				priceChoice1 = mwOption.getMineralWoolcost();
				priceChoice2 = gfOption.getGlassFibercost();
				priceChoice3 = sfOption.getSprayFoamcost();
				
			}
			if (userOption == 3){//windows
				optionChoice1 = glzOPtion.name();
				optionChoice2 = thOption.name();
				optionChoice3 = tpOption.name();
				priceChoice1 = glzOPtion.getGlazedcost();
				priceChoice2 = thOption.getThermalcost();
				priceChoice3 = tpOption.getTriplePanecost();
				
			}
			//if (choice.option == 2){// insulation
				
				/*MineralWool option1 = new MineralWool(0,0);
				choiceOptions1 = option1.name();
				GlassFiber option2 = new GlassFiber(0,0);
				choiceOptions2 = option2.name();
				SprayFoam option3 = new SprayFoam(0,0);
				*/
			//}
			//if (choice.option == 3){// windows
				
				//Glazed option1 = new Glazed(0,0);
				//option1 = option1.name();
				//Thermal option2 = new Thermal(0,0);
				//choiceOptions2 = option2.name();
				
			//}
			
			//System.out.println();
			
			//System.out.println(optionChoice1);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton(optionChoice1);
			rdbtnNewRadioButton.setBounds(20, 94, 109, 23);
			frame.getContentPane().add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(optionChoice2);
			rdbtnNewRadioButton_1.setBounds(20, 169, 109, 23);
			frame.getContentPane().add(rdbtnNewRadioButton_1);
			
			/*if (userOption == 3){
				JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(optionChoice3);
				rdbtnNewRadioButton_2.setBounds(20, 246, 109, 23);
				frame.getContentPane().add(rdbtnNewRadioButton_2);
			}
			*/
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(optionChoice3);
			rdbtnNewRadioButton_2.setBounds(20, 246, 109, 23);
			frame.getContentPane().add(rdbtnNewRadioButton_2);
			
			JButton btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					//PricePage nxt = new PricePage(priceChoice1);
					if (rdbtnNewRadioButton.isSelected()){
						
						PricePage nxt = new PricePage(priceChoice1);
						frame.setVisible(false);
						nxt.frame.setVisible(true);
						
					}
					if (rdbtnNewRadioButton_1.isSelected()){
						PricePage nxt = new PricePage(priceChoice2);
						frame.setVisible(false);
						nxt.frame.setVisible(true);
					}
					if (rdbtnNewRadioButton_2.isSelected()){
						
						PricePage nxt = new PricePage(priceChoice3);
						frame.setVisible(false);
						nxt.frame.setVisible(true);
					}
					
				}
			});
			btnNext.setBounds(322, 452, 89, 23);
			frame.getContentPane().add(btnNext);
			
			JButton btnBack2 = new JButton("Back");
			btnBack2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StartPage back = new StartPage();
					back.frame.setVisible(true);
					frame.setVisible(false);
					
					
					
				}
			});
			btnBack2.setBounds(20, 452, 89, 23);
			frame.getContentPane().add(btnBack2);
			
			
			JButton btnHome = new JButton("Home");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Intro back =  new Intro();
					frame.setVisible(false);
					back.frame.setVisible(true);
					
				}
			});
			btnHome.setBounds(166, 452, 89, 23);
			frame.getContentPane().add(btnHome);
			
			JButton btnAbout = new JButton("?"); //about
			btnAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				AboutPage about = new AboutPage();
				about.aboutFrame.setVisible(true);
					
				}
			});
			btnAbout.setBounds(365, 11, 46, 25);
			frame.getContentPane().add(btnAbout);
			
		}
	}
	
	/**
	 * Price/energy class, user inputs quantity and receives pricing cost/energy saved
	 * 
	 * @author Fasil Ayenew
	 */
	public class PricePage {

		JFrame frame;
		JFrame aboutFrame;
		JTextField textField;
		JTextField textField2;
		JTextArea textArea;
		String strTextField;
		double intTextField;
		int totalAmount;
		int totalAmount2;
		float price;
		//Project myList = new Project(" ");
		
		
		
		public PricePage(float prc) {
			price = prc;
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {	
			
			frame = new JFrame();
			frame.setVisible(false);
			frame.setBounds(100, 100, 450, 549);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblBulbOptions2 = new JLabel("Price/Saving");
			lblBulbOptions2.setFont(new Font("Serif", Font.PLAIN, 19));
			lblBulbOptions2.setBounds(161, 11, 133, 25);
			frame.getContentPane().add(lblBulbOptions2);
			
			
			
			JLabel lblenterQuantity = new JLabel("-Enter Quantity($" + price + "): ");
			lblenterQuantity.setBounds(29, 79, 188, 25);
			frame.getContentPane().add(lblenterQuantity);
			
			textField = new JTextField(); //user input for quantity
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			textField.setBounds(29, 110, 86, 20);
			//System.out.println(price);
			
			if (price != 13 && price != 2 && price != 20){// sq ft input
				
				JLabel lblenterSquareFeet = new JLabel();
				lblenterSquareFeet = new JLabel("-Enter square feet:");
				lblenterSquareFeet.setBounds(29, 141, 107, 14);
				frame.getContentPane().add(lblenterSquareFeet);
				
				textField2 = new JTextField(); //user input for quantity
				frame.getContentPane().add(textField2);
				textField2.setColumns(10);
				textField2.setBounds(29, 162, 86, 20);
				
			}
			
			JLabel lblLedBulbs = new JLabel("total");
			lblLedBulbs.setBounds(134, 113, 46, 14);
			frame.getContentPane().add(lblLedBulbs);
			
			
			JButton btnOkay = new JButton("okay");
			btnOkay.setBounds(205, 109, 63, 23);
			frame.getContentPane().add(btnOkay);
			
			
			
			textArea = new JTextArea();//display
			textArea.setBounds(47, 252, 366, 105);
			
			frame.getContentPane().add(textArea);
			
			JLabel lblTotalCost = new JLabel("total cost:");
			lblTotalCost.setBounds(29, 207, 70, 14);
			frame.getContentPane().add(lblTotalCost);
			
			System.out.println(price);
			btnOkay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//totalAmount = Integer.parseInt(textField.getText());
					
					//System.out.println(totalAmount);
					//System.out.println(totalAmount2);
					
					if (price == 13){//led
						//System.out.println("led is correct");
						LED costNumbers = new LED(Integer.parseInt(textField.getText()));
						textArea.setText("Total cost for LED is: $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) +
						"\n\nEnergy Consumption per day(12hr) is: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " watts" + 
						"\n\nEnergy Comparison with incandescent: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " watts");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
						
						
					}
					if (price == 2){//cfl
						//System.out.println("cfl is correct");
						CFL costNumbers = new CFL(Integer.parseInt(textField.getText()));
						textArea.setText("Total cost for CFL is: $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) +
						"\n\nEnergy Consumption per day(12hr) is: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " watts" +
						"\n\nEnergy Comparison with incandescent: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " watts");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
					if (price == 20){//halogen
						//System.out.println("halogen is correct");
						Halogen costNumbers = new Halogen(Integer.parseInt(textField.getText()));
						textArea.setText("Total cost for Halogen is: $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) +
						"\n\nEnergy Consumption per day(12hr) is: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " watts" + 
						"\n\nEnergy Comparison with incandescent: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " watts");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
					if (price == 10.75){//mineral wool
						//System.out.println("mineral wool is correct");
						MineralWool costNumbers = new MineralWool(Integer.parseInt(textField.getText()), 
								Integer.parseInt(textField2.getText()));
						textArea.setText("Total cost for Mineral Wool is : $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) + 
						"\n\nWorst energy consumption per day per 24 hour: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " kw" + 
						"\n\nTotal energy consumption per day for 24 hours: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " kw");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
					if (price == 3){//glass fiber
						//System.out.println("glass fiber is correct");
						GlassFiber costNumbers = new GlassFiber(Integer.parseInt(textField.getText()), 
								Integer.parseInt(textField2.getText()));
						textArea.setText("Total cost for Glass Fiber is : $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) + 
						"\n\nWorst energy consumption per day per 24 hour: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " kw" + 
						"\n\nTotal energy consumption per day for 24 hours: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " kw");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
					if (price == 1){//spray foam
						//System.out.println("glass fiber is correct");
						SprayFoam costNumbers = new SprayFoam(Integer.parseInt(textField.getText()), 
								Integer.parseInt(textField2.getText()));
						textArea.setText("Total cost for Spray Foaml is : $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) + 
						"\n\nWorst energy consumption per day per 24 hour: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " kw" + 
						"\n\nTotal energy consumption per day for 24 hours: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " kw");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
					if (price == 24){//glazed
						
						Glazed costNumbers = new Glazed(Integer.parseInt(textField.getText()), 
								Integer.parseInt(textField2.getText()));
						textArea.setText("Total cost for Glazed is : $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) + 
						"\n\nWorst energy consumption per day per 24 hour: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " kw" + 
						"\n\nTotal energy consumption per day for 24 hours: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " kw");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
					if (price == 17){//thermal
						
						Thermal costNumbers = new Thermal(Integer.parseInt(textField.getText()), 
								Integer.parseInt(textField2.getText()));
						textArea.setText("Total cost for Thermal is : $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) + 
						"\n\nWorst energy consumption per day per 24 hour: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " kw" + 
						"\n\nTotal energy consumption per day for 24 hours: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " kw");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
					if (price == 10){//triple
						
						TriplePane costNumbers = new TriplePane(Integer.parseInt(textField.getText()), 
								Integer.parseInt(textField2.getText()));
						textArea.setText("Total cost for Triple Pane is : $" + 
						String.valueOf(costNumbers.getPriceForQuantity()) + 
						"\n\nWorst energy consumption per day per 24 hour: " + 
						costNumbers.getBaseEnergyConsumptionForQuantity() + " kw" + 
						"\n\nTotal energy consumption per day for 24 hours: " + 
						costNumbers.getEnergyConsumptionForQuantity() + " kw");
						textArea.setEditable(false);
						
						myList.addItem(costNumbers);
					}
				}
			});
			
			
			JButton btnNext3 = new JButton("Add");
			btnNext3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					/*if (!(textField.getText().isEmpty())){
						
						SummaryPage nxt = new SummaryPage(myList);
						frame.setVisible(false);
						nxt.frame.setVisible(true);
					}
					*/
					isNew = false;
					frame.setVisible(false);
					StartPage add = new StartPage();
					add.frame.setVisible(true);
					
					
				}
			});
			btnNext3.setBounds(322, 452, 89, 23);
			frame.getContentPane().add(btnNext3);
			
			
			JButton btnBack2 = new JButton("Back");
			btnBack2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//frame.setVisible(false);
					//OptionPage back = new OptionPage();
					//back.frame.setVisible(true);
						
					
				}
			});
			
			btnBack2.setBounds(20, 452, 89, 23);
			frame.getContentPane().add(btnBack2);	
			
			
			JButton btnHome = new JButton("Finish");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					/*Intro back =  new Intro();
					frame.setVisible(false);
					back.frame.setVisible(true);
					*/
					isNew = true;
					if (!(textField.getText().isEmpty())){
					
					SummaryPage nxt = new SummaryPage(myList);
					frame.setVisible(false);
					nxt.frame.setVisible(true);
					
				}
				
				}
			});
			btnHome.setBounds(166, 452, 89, 23);
			frame.getContentPane().add(btnHome);
			
			JButton btnAbout = new JButton("?"); //about
			btnAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AboutPage about = new AboutPage();
					about.aboutFrame.setVisible(true);
					
				}
			});
			btnAbout.setBounds(365, 11, 46, 25);
			frame.getContentPane().add(btnAbout);
		}
	}
	
	public class SummaryPage {

		JFrame frame;
		JTextArea textArea;
		int option;
		Project myNewList;
		String finale;
		public SummaryPage(Project myList) {
			myNewList = myList;
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 549);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible (true);
			textArea = new JTextArea ();
			//textArea.setText();
			textArea.setText(myNewList.showItems() + "total cost is : $" + String.valueOf(myNewList.getTotalCost()));
			//textArea.setText(String.valueOf(myNewList.showItems()));
			textArea.setEditable(false);
			//gittestudsfhdiofgfdoighod

			JScrollPane scroll = new JScrollPane (textArea, 
			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			frame.add(scroll);
			
			
			
			//System.out.println("total cost is : $");
			//System.out.print(myNewList.getTotalCost());
			
		}
	}




}

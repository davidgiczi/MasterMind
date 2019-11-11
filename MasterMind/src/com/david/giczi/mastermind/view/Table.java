package com.david.giczi.mastermind.view;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.david.giczi.mastermind.controller.ColorNumberListener;
import com.david.giczi.mastermind.controller.DifferentColorListener;
import com.david.giczi.mastermind.controller.ExitListener;
import com.david.giczi.mastermind.controller.GameFieldsListener;
import com.david.giczi.mastermind.controller.NewGameListener;
import com.david.giczi.mastermind.controller.ShowThePatternListener;
import com.david.giczi.mastermind.controller.TippCheckingListener;
import com.david.giczi.mastermind.model.MasterMindLogic;



public class Table {
	
	
	private JFrame frame= new JFrame();
	private JButton[] gameFields = new JButton[44];
	private JButton[] resultFields = new JButton[44];
	private JCheckBox[] resultChecks = new JCheckBox[44];
	private JCheckBox[] checkInput = new JCheckBox[11];
	private JMenu configMenu;
	private JMenuItem exit;
	private JMenuItem newGame;
	private MasterMindLogic logic = new MasterMindLogic();
	private List<JFrame> frameStore = new ArrayList<>();
	private int cloneTableXposition = -40;
	private int cloneTableYposition = -40;
	
	
	public JFrame getFrame() {
		return frame;
	}
	
	
	public JButton[] getGameFields() {
		return gameFields;
	}

	
	public JMenu getConfigMenu() {
		return configMenu;
	}
	
	public JCheckBox[] getCheckInput() {
		return checkInput;
	}
	

	public JMenuItem getExit() {
		return exit;
	}
	
	public JMenuItem getNewGame() {
		return newGame;
	}


	public Table() {
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("MasterMind - Colors: 6, Different colors: Yes, Round: -");
		
		frame.setSize(500, 700);
		
		int x =(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()-frame.getWidth())/2;
		int y = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-frame.getHeight())/2;
		
		frame.setLocation(x, y);
		
		frame.setLayout(new GridLayout(1,2));
	
		createMenuComponent();
	
		createRows();
		
		frame.setVisible(true);
		
		logic.rand4DifferentColors();
	}
	
	
	private void createRows() {
		
		
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		rightPanel.setBackground(new Color(165,124,0));
		
		leftPanel.setLayout(new GridLayout(11,4));
		rightPanel.setLayout(new GridLayout(11,5));
		
		for(int i = 0; i < gameFields.length; i++) {
			
			
			gameFields[i] = new JButton();
			
			
			if(i > 3) {
				
				gameFields[i].setBackground(new Color(165,124,0));
				gameFields[i].addActionListener(new GameFieldsListener(logic, gameFields[i], i));
			}
			else {
				
				gameFields[i].setBackground(new Color(153,101,21));
				gameFields[i].setEnabled(false);
				
			}
			
			leftPanel.add(gameFields[i]);
				
			}
		
		
		
		int counter=0;
		
		for(int i = 0; i < resultFields.length; i++) {
			
			
			if( i % 4 == 0) {
				
				checkInput[counter] = new JCheckBox();
				
				checkInput[counter].setBackground(new Color(165,124,0));
				
				if( counter == 0 ) {
					
				checkInput[counter].setVisible(false);
					
				}
				else {
					
					checkInput[counter].addActionListener(new TippCheckingListener(this, logic, counter));
					
				}
			
			rightPanel.add(checkInput[counter++]);
				
		}
			
			resultFields[i] = new JButton();
			resultChecks[i] = new JCheckBox();
			
			resultFields[i].setBackground(new Color(165,124,0));
			resultFields[i].setEnabled(false);
			
			resultChecks[i].setBackground(new Color(165,124,0));
			resultChecks[i].setEnabled(false);
			
			
			if( i < 4 ) {
				
				resultFields[i].setVisible(false);
				
			}
			
			
			resultFields[i].add(resultChecks[i]);
			rightPanel.add(resultFields[i]);
			
			}	
		
		
		frame.add(leftPanel);
		frame.add(rightPanel);
		
		
	}

	
	private void createMenuComponent() {
		
		JMenuBar menuBar = new JMenuBar();
		JMenu option = new JMenu("Options");
		      configMenu = new JMenu("Config");
		JMenuItem showPattern = new JMenuItem("Show the Pattern");
		      newGame = new JMenuItem("New Game");
			  exit = new JMenuItem("Exit");
		JMenu numberOfColors = new JMenu("Number of Colors");
		JMenu diffColors = new JMenu("Different Colors");
		JMenuItem yes = new JMenuItem("Yes");
		JMenuItem no = new JMenuItem("No");
		JMenuItem four = new JMenuItem("4");
		JMenuItem five = new JMenuItem("5");
		JMenuItem six = new JMenuItem("6");
		JMenuItem seven = new JMenuItem("7");
		JMenuItem eight = new JMenuItem("8");
		JMenuItem nine = new JMenuItem("9");
		JMenuItem ten = new JMenuItem("10");
		
		diffColors.add(yes);
		diffColors.add(no);
		numberOfColors.add(four);
		numberOfColors.add(five);
		numberOfColors.add(six);
		numberOfColors.add(seven);
		numberOfColors.add(eight);
		numberOfColors.add(nine);
		numberOfColors.add(ten);
		configMenu.add(diffColors);
		configMenu.add(numberOfColors);
		option.add(configMenu);
		option.addSeparator();
		option.add(newGame);
		option.add(showPattern);
		option.addSeparator();
		option.add(exit);
		menuBar.add(option);
		
		
		exit.addActionListener(new ExitListener(this));
		four.addActionListener(new ColorNumberListener(this, logic, 4));
		five.addActionListener(new ColorNumberListener(this, logic,  5));
		six.addActionListener(new ColorNumberListener(this, logic, 6));
		seven.addActionListener(new ColorNumberListener(this, logic, 7));
		eight.addActionListener(new ColorNumberListener(this, logic, 8));
		nine.addActionListener(new ColorNumberListener(this, logic, 9));
		ten.addActionListener(new ColorNumberListener(this, logic, 10));
		yes.addActionListener(new DifferentColorListener(this, logic, "Yes"));
		no.addActionListener(new DifferentColorListener(this, logic, "No"));
		showPattern.addActionListener(new ShowThePatternListener(this, logic));
		newGame.addActionListener(new NewGameListener(this, logic));
			
		frame.setJMenuBar(menuBar);
		
	}
	
	public boolean decidingWindow(String text) {
		
		if( JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(frame, text, "MasterMind", JOptionPane.YES_OPTION)) {
			
			return true;
		}
		
		
		return false;
	}
	
	
	
	public void informingWindow(String text) {
		
		JOptionPane.showMessageDialog(frame, text , "MasterMind", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	public void setTitle(String text) {
		
		frame.setTitle(text);
		
	}
	
	
	public void init() {
		
		
		configMenu.setEnabled( true );
		

		for ( int i=0; i < gameFields.length; i++) {
			
			
			
			if( i > 3 ) {
				
				gameFields[i].setBackground( new Color(165,124,0) );
				gameFields[i].setEnabled(true);
				 
			}
			else {
				
				gameFields[i].setBackground(new Color(153,101,21));
				
			}
			
			resultChecks[i].setSelected( false );
			
			resultChecks[i].setBackground( new Color(165,124,0) );
			
			resultChecks[i].setEnabled( false );
			
		}
		
		
		for (JCheckBox check : checkInput) {
			
			check.setEnabled(true);
			check.setSelected(false);
			
		}
		
		
	}
	
	public void showTheResult(Boolean[] result, int rowIndex) {
		
		
		int checkIndex = 4*rowIndex;
		
		
		for ( int i = 0; i < result.length; i++ ) {
			
			
			if( result[i] != null && result[i] ) {
				
				resultChecks[checkIndex].setEnabled(true);
				resultChecks[checkIndex].doClick();
				
				
			}
			else if( result[i] != null && !result[i] ) {
				
				resultChecks[checkIndex].setEnabled(true);
				
			}
			
			
			checkIndex++;
			
		}
		
	}
	
	public void disbledActualRow(int rowIndex) {
		
		
		int fieldIndex = 4*rowIndex;
	
		for( int i=0; i < 4; i++ ) {
			
			gameFields[fieldIndex++].setEnabled(false);
			
		}
		
		checkInput[rowIndex].setEnabled(false);
		
	}
	
	
	public void createTitleByColorNumber(int colorNumber) {
		
		String text = frame.getTitle();
		
		String[] storeText = text.split(",");
		
		String newText = storeText[0].substring(0,20);
		
		frame.setTitle(newText+" "+colorNumber+","+storeText[1]+","+storeText[2]);
		
	}
	
	
	public void createTitleByRoundNumber(int roundCounter) {
		
		
		String title = frame.getTitle();
		
		if( roundCounter > 10 ) {
			
			title = title.substring(0, title.length()-3);
		}
		else {
			
			title = title.substring(0, title.length()-2);
		}
		
		
		if( roundCounter == 0 ) {
			
			frame.setTitle(title+" -");
		}
		else {
			
			frame.setTitle( title+" "+logic.getRoundCounter() );
			
		}
			
		
		
	}
	
	public void createTitleByDifferentColorOption(String yesNoOption) {
		
		
		String text = frame.getTitle();
		
		String[] storeText = text.split(",");
		
		String newText = storeText[1].substring(0,18)+" "+yesNoOption;
		
		frame.setTitle(storeText[0]+","+newText+","+storeText[2]);
		
	}
	
	
	public void createCloneTable() {
		
		JFrame cloneFrame = new JFrame(frame.getTitle());
		JPanel cloneLeftPanel = new JPanel();
		JPanel cloneRightPanel = new JPanel();
		
		cloneLeftPanel.setLayout(new GridLayout(11,4));
		cloneRightPanel.setLayout(new GridLayout(11,5));
		
		cloneFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		cloneTableXposition += 50;
		cloneTableYposition += 50;
		
		cloneFrame.setLocation(cloneTableXposition, cloneTableYposition);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu option = new JMenu("Options");
		
		menuBar.add(option);
		
		cloneFrame.setSize(500, 700);
		
		cloneFrame.setJMenuBar(menuBar);
		
		
		cloneFrame.add(cloneLeftPanel);
		cloneFrame.add(cloneRightPanel);
		
		cloneFrame.setVisible(true);
		
		frameStore.add(cloneFrame);
		
	}
	
	
	public void destroyCloneTables() {
		
		
		for (JFrame cloneFrame : frameStore) {
			
			cloneFrame.setVisible(false);
			cloneFrame = null;
			
		}
		
		frameStore.clear();
		
		cloneTableXposition = -40;
		cloneTableYposition = -40;
		
	}
	
}

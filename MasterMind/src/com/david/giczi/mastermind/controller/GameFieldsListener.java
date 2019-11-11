package com.david.giczi.mastermind.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.david.giczi.mastermind.model.MasterMindLogic;
import com.david.giczi.mastermind.model.Colors;

public class GameFieldsListener implements ActionListener {
	
	private JButton button;
	private int clickCounter = 0;
	private int index;
	private MasterMindLogic logic;
	

	public GameFieldsListener(MasterMindLogic logic, JButton button, int index) {
		
		this.logic = logic;
		this.button = button;
		this.index = index;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if ( logic.getTippStore()[ index % 4 ] == null ) {
			
			clickCounter = 0;
		}
		
		
		switch (clickCounter) {
		
		case 0:
			
			button.setBackground(Color.BLUE);
			logic.addColorToTippStore(Colors.BLUE, index);
			break;
			
		case 1:
			
			button.setBackground(Color.GREEN);
			logic.addColorToTippStore(Colors.GREEN, index);
			break;
		case 2:
	
			button.setBackground(new Color(101,101,101));
			logic.addColorToTippStore(Colors.GREY, index);
			break;
		case 3:
			
			button.setBackground(new Color(0,255,255));
			logic.addColorToTippStore(Colors.LIGHTBLUE, index);
			break;
		case 4:
			
			button.setBackground(Color.ORANGE);
			logic.addColorToTippStore(Colors.ORANGE, index);
			break;
		case 5:
			
			button.setBackground(new Color(255,0,255));
			logic.addColorToTippStore(Colors.PINK, index);
			break;
		case 6:
			
			button.setBackground(new Color(127,0,255));
			logic.addColorToTippStore(Colors.PURPLE, index);
			break;
		case 7:
			
			button.setBackground(Color.RED);
			logic.addColorToTippStore(Colors.RED, index);
			break;
		case 8:
			
			button.setBackground(Color.WHITE);
			logic.addColorToTippStore(Colors.WHITE, index);
			break;
		case 9:
	
			button.setBackground(Color.YELLOW);
			logic.addColorToTippStore(Colors.YELLOW, index);
		}
		
		
		clickCounter++;
		
		if(clickCounter == logic.getNumberOfColor()) {
			
			clickCounter = 0;
		}
		
		
	}

	
	
	
}

package com.david.giczi.mastermind.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.mastermind.model.MasterMindLogic;
import com.david.giczi.mastermind.model.NotEnoughColorInputValueException;
import com.david.giczi.mastermind.view.Table;

public class TippCheckingListener implements ActionListener {

	
	
	private Table table;
	private MasterMindLogic logic;
	private int index;
	
	
	public TippCheckingListener(Table table, MasterMindLogic logic, int counter) {
		
		this.table = table;
		this.logic = logic;
		index = counter;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
			table.getConfigMenu().setEnabled(false);
			
			
			
			try {
				
				
				logic.controlInputColorFields();
				
				
			} catch (NotEnoughColorInputValueException e1) {
				
				table.informingWindow("Please, choose color for all (4) the fields!");
				table.getCheckInput()[index].setSelected(false);
				return;
			}
			
			
					
			logic.evaluate();
			
			table.createTitleByRoundNumber( logic.getRoundCounter() );
			
			logic.orderResultStore();
			
			table.showTheResult(logic.getResultStore(), index);
			
			table.disbledActualRow(index);
			
			
			if( logic.isWinner() ) {
				
				if( table.decidingWindow("Congratulations! Would you like to play a new game?")) {
					
					table.getNewGame().doClick();
					
				}
				else {
					
	
						table.getExit().doClick();
						
					
					
				}
				
				
			}
			
			
			
			
			if( logic.getRoundCounter() > 0 && logic.getRoundCounter() % 10 == 0 ) {
				
				
			if(	table.decidingWindow("Would you like to continue the game?")) {
				
				
				if( table.decidingWindow("Would you like to see the previous steps?")) {
					
					
					
					
				}
				else {
					
					
					
					
					
				}
				
			}
			else {
				
				
					if( table.decidingWindow("Would you like to play a new game?")) {
						
						
						table.getNewGame().doClick();
						
					}
					else {
						
						table.getExit().doClick();
					
						
					}
				
				
		}
				
	}
			
			logic.initResultAndTippStore();
			
			
			
		
	}

	
	
	
	
	
	
}

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
		
		
		if(table.getCheckInput()[index].isSelected()) {
			
			table.getConfigMenu().setEnabled(false);
			
			
			
			try {
				
				
				logic.controlInputColorFields();
				
				
			} catch (NotEnoughColorInputValueException e1) {
				
				table.informMessage("Please, choose color for all (4) fields!");
				table.getCheckInput()[index].setSelected(false);
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
	}

}

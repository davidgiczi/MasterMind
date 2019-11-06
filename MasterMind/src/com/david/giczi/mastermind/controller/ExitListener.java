package com.david.giczi.mastermind.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.mastermind.view.Table;

public class ExitListener implements ActionListener {
	
	
	private Table table;
	
	public ExitListener(Table table) {
		
		this.table = table;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if( table.doExit() ) {
			
			System.exit(0);
		}
		
		
	}

}

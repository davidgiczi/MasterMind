package com.david.giczi.mastermind.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.mastermind.model.MasterMindLogic;
import com.david.giczi.mastermind.view.Table;

public class NewGameListener implements ActionListener {
	
	
	
	private MasterMindLogic logic;
	private Table table;
	
	
	public NewGameListener(Table table, MasterMindLogic logic) {
		
		this.logic = logic;
		this.table = table;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		logic.init();
		table.init();
		
		table.createTitleByRoundNumber(0);
		
		
		
	}

}

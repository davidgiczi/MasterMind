package com.david.giczi.mastermind.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.mastermind.model.MasterMindLogic;
import com.david.giczi.mastermind.view.Table;

public class DifferentColorListener implements ActionListener {

	
	private Table table;
	private String yesNoOption;
	private MasterMindLogic logic;
	
	
	
	public DifferentColorListener(Table table, MasterMindLogic logic, String yesNoOption) {
		
		this.table = table;
		this.logic = logic;	
		this.yesNoOption = yesNoOption;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if("Yes".equals(yesNoOption)) {
			
			logic.setIsDifferentColors(true);
		}
		
		else {
			
			logic.setIsDifferentColors(false);	
		}

		table.createTitleByDifferentColorOption(yesNoOption);
		
		logic.init();
		table.init();
		
		table.createTitleByRoundNumber(0);
		
	}
	
	
	
}

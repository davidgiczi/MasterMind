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

		setTitle();
			
		
	}
	
	
	private void setTitle() {
		
		
		String text = table.getFrame().getTitle();
		
		String[] storeText = text.split(",");
		
		String newText = storeText[1].substring(0,18)+" "+yesNoOption;
		
		table.setTitle(storeText[0]+","+newText+","+storeText[2]);
		
	}
	
	
}

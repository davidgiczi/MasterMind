package com.david.giczi.mastermind.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.mastermind.view.Table;

public class DifferentColorListener implements ActionListener {

	
	private Table table;
	private String yesNoOption;
	
	
	
	public DifferentColorListener(Table table, String yesNoOption) {
		
		this.table = table;
		this.yesNoOption = yesNoOption;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		

		String text = table.getFrame().getTitle();
		
		String[] storeText = text.split(",");
		
		String newText = storeText[1].substring(0,18)+" "+yesNoOption;
		
		
		table.setTitle(storeText[0]+","+newText+","+storeText[2]);
			
		
	}
	
}

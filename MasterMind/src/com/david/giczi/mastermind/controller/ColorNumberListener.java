package com.david.giczi.mastermind.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.mastermind.model.MasterMindLogic;
import com.david.giczi.mastermind.view.Table;

public class ColorNumberListener implements ActionListener {
	
	
	private Table table;
	private int colorNumber;
	private MasterMindLogic logic;
	
	
	
	public ColorNumberListener(Table table, MasterMindLogic logic, int colorNumber) {
		
		this.table = table;
		this.logic = logic;
		this.colorNumber = colorNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		logic.setNumberOfColor(colorNumber);
		
		setTitle();
		
		logic.init();
		
	}

	private void setTitle() {
		
		String text = table.getFrame().getTitle();
		
		String[] storeText = text.split(",");
		
		String newText = storeText[0].substring(0,20);
		
		table.setTitle(newText+" "+colorNumber+","+storeText[1]+","+storeText[2]);
		
	}
	
	
	
}

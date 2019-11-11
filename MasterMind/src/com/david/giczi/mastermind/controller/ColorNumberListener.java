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
		
		table.createTitleByColorNumber(colorNumber);
		
		logic.init();
		table.init();
		
		table.createTitleByRoundNumber(0);
	}

	
	
}

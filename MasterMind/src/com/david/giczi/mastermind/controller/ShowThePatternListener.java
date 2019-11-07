package com.david.giczi.mastermind.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.david.giczi.mastermind.model.Colors;
import com.david.giczi.mastermind.model.MasterMindLogic;
import com.david.giczi.mastermind.view.Table;

public class ShowThePatternListener implements ActionListener {

	private Table table;
	private MasterMindLogic logic;
	
	public ShowThePatternListener(Table table, MasterMindLogic logic) {
		
		this.table = table;
		this.logic = logic;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	for( int i = 0; i < logic.getColorStore().size(); i++) {
		
		
		
		if( logic.getColorStore().get(i) == Colors.BLUE ) {
			
			
			table.getGameFields()[i].setBackground(Color.BLUE);
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.GREEN ) {
			
			
			table.getGameFields()[i].setBackground(Color.GREEN);
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.GREY ) {
			
			
			table.getGameFields()[i].setBackground(new Color(101,101,101));
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.LIGHTBLUE ) {
			
			
			table.getGameFields()[i].setBackground(new Color(0,255,255));
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.ORANGE ) {
			
			
			table.getGameFields()[i].setBackground(Color.ORANGE);
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.PINK ) {
			
			
			table.getGameFields()[i].setBackground(new Color(255,0,255));
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.PURPLE ) {
			
			
			table.getGameFields()[i].setBackground(new Color(127,0,255));
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.RED ) {
			
			
			table.getGameFields()[i].setBackground(Color.RED);
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.WHITE ) {
			
			
			table.getGameFields()[i].setBackground(Color.WHITE);
			
			
		}
		else if( logic.getColorStore().get(i) == Colors.YELLOW ) {
			
			
			table.getGameFields()[i].setBackground(Color.YELLOW);
			
			
			}
		
		
		}
		
	}

}

package com.david.giczi.mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class MasterMindLogic {
	
	
	private List<Colors> colorStore;
	private Colors[] tippStore = new Colors[4];
	private Boolean[] result = new Boolean[4];
	private int numberOfColor = 6;

	
	public MasterMindLogic() {
		
		
		for(int i=0; i < result.length; i++) {
			
			result[i] = null;
			tippStore[i] = null;
		}
		
	}
	
	

	public Colors[] getTippStore() {
		return tippStore;
	}





	public void setTippStore(Colors[] tippStore) {
		this.tippStore = tippStore;
	}

	
	public int getNumberOfColor() {
		return numberOfColor;
	}



	public void setNumberOfColor(int numberOfColor) {
		this.numberOfColor = numberOfColor;
	}
	
	
	public void rand4NotDifferenetColors()	{
		
		colorStore = new ArrayList<>();
		
		while(colorStore.size() < 4) {
			
			
			int value = (int) (Math.random() * numberOfColor);
			
			
			switch (value) {
			
			case 0 :
					
				colorStore.add(Colors.BLUE);
				
				break;

			case 1 :
				
				colorStore.add(Colors.GREEN);
				
				break;
				
			case 2 :
				
				colorStore.add(Colors.GREY);
				
				break;	
				
			case 3 :
				
				colorStore.add(Colors.LIGHTBLUE);
			
				break;	
				
			case 4 :
				
				colorStore.add(Colors.ORANGE);
			
				break;	
				
			case 5 :
				
				colorStore.add(Colors.PINK);
			
				break;
				
			case 6 :
				
				colorStore.add(Colors.PURPLE);
			
				break;	
			
			case 7 :
				
				colorStore.add(Colors.RED);
	
				break;
				
			case 8 :
				
				colorStore.add(Colors.WHITE);
	
				break;
				
			case 9 :
				
				colorStore.add(Colors.YELLOW);
				
			}
			
			
			
		}
			
		
	}


	public void rand4DifferenetColors()	{
		
		
		colorStore = new ArrayList<>();
		
		
		while(colorStore.size() < 4) {
			
			
			int value = (int) (Math.random() * numberOfColor);
			
			
			switch (value) {
			
			case 0 :
				
				if(!colorStore.contains(Colors.BLUE)) {
					colorStore.add(Colors.BLUE);
				}
				
				
				break;

			case 1 :
				
				if(!colorStore.contains(Colors.GREEN)) {
					colorStore.add(Colors.GREEN);
				}
				
				
				break;
				
			case 2 :
				
				if(!colorStore.contains(Colors.GREY)) {
					colorStore.add(Colors.GREY);
				}
				
				
				break;	
				
			case 3 :
				
				if(!colorStore.contains(Colors.LIGHTBLUE)) {
					colorStore.add(Colors.LIGHTBLUE);
				}
				
				
				break;	
				
			case 4 :
				
				if(!colorStore.contains(Colors.ORANGE)) {
					colorStore.add(Colors.ORANGE);
				}
				
				
				break;	
				
			case 5 :
				
				if(!colorStore.contains(Colors.PINK)) {
					colorStore.add(Colors.PINK);
				}
				
				
				break;
				
			case 6 :
				
				if(!colorStore.contains(Colors.PURPLE)) {
					colorStore.add(Colors.PURPLE);
				}
				
				
				break;	
			
			case 7 :
				
				if(!colorStore.contains(Colors.RED)) {
					colorStore.add(Colors.RED);
				}
				
				
				break;
				
			case 8 :
				
				if(!colorStore.contains(Colors.WHITE)) {
					colorStore.add(Colors.WHITE);
				}
				
				
				break;
				
			case 9 :
				
				if(!colorStore.contains(Colors.YELLOW)) {
					colorStore.add(Colors.YELLOW);
				}
				
			}
					
			
		}
		
	}
	
	public void controlInputColorFields() throws NotEnoughColorInputValueException {
		
		for (Colors color : colorStore) {
			
			if(color == null) {
				
				throw new NotEnoughColorInputValueException();
			}
		}
		
		
	}
	
	public void addColorToTippStore(Colors tipp, int index) {
		
			index = index % 4;
			
			tippStore[index] = tipp;
			
	}
	
	
	public void evaluate() {
		
		
		for(int i=0; i < colorStore.size(); i++) {
			
			if(colorStore.get(i) == tippStore[i]) {
				
				result[i] = true;
				
			}
			else if(colorStore.contains(tippStore[i])) {
				
				result[i] = false;
			}
			
		}
		
		
	}

	

}

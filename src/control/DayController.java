package control;

import gameElements.World;
import worldElements.*;

public class DayController {
	
	World world;
	
	public boolean nextDay(){
		//TODO, of course.
		try{
		for(int n=0;n<world.places.size();n++){
			if (world.places.get(n) instanceof City){
				world.places.set(n,(((City) world.places.get(n)).grow()));
			}
		}
		return true;
		
		}catch(Exception e){
			Controller.print("Could not advance day!");
			return false;
		}
	}
	
	public void setWorld(World world){
		this.world=world;
	}
}

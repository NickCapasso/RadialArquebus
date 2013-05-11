package worldElements;

import control.Controller;
import gameElements.World;


public class Player extends Person {
	int cash;

	public Player(String name) {
		super(name);
		cash = 0;
	}
	
	public Place[] getPlacesHere(World world){
		return world.getInfluencingPlaces(this.pos);
	}
	
	public void printPos(){
		Controller.print("You are "+pos.toString());
	}
	
	public void move(int dist, int theta){
		pos.move(dist, theta);
	}
}

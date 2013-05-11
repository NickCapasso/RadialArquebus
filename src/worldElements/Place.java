package worldElements;

import gameElements.World;
import util.Position;

public abstract class Place {
	protected Position location;
	protected int radius; //radius of influence
	public String name;
	protected World world;
	
	Place(){
		location = new Position(0,0);
		radius=0;
	}
	
	Place(Position position, int ROI, World world){
		location = position;
		radius=ROI;
		this.world=world;
	}
	
	public boolean isInfluencedBy(Place other){
		if(distToOtherPlace(other)<other.radius||distToOtherPlace(other)<this.radius){
			return true;
		}else{
			return false;
		}
	}
	
	public int distToOtherPlace(Place other){
		return location.getDistanceTo(other.getLocation());
	}
	
	public Position getLocation(){
		return this.location;
	}
	
	public World getWorldIn(){
		return world;
	}
}

package util;

public class Position {
	//Basically a chopped down version of the Vector class.
	
	private double distance;
	private double direction;
	
	public final double NORTH = 90.0;
	public final double SOUTH = 270.0;
	public final double EAST = 0.0;
	public final double WEST = 180.0;
	
	public Position(double dist, double theta){
		distance=dist;
		direction=theta;
	}
	
	public int getDistanceTo(Position p2){
		double[] c1=this.getPosxy();
		double[] c2=p2.getPosxy();
		return (int) Math.sqrt(Math.pow(c1[0]-c2[0], 2)+Math.pow(c1[1]-c2[1], 2));
	}
	
	public double[] getPosxy(){
		double[] coordinates = new double[2];
		coordinates[0]=(distance*Math.cos(direction));
		coordinates[1]=(distance*Math.sin(direction));
		return coordinates;
	}
	
	public void move(int dist, int theta){
		Position temp = new Position(dist, theta);
		double[] c1 = this.getPosxy();
		double[] c2 = temp.getPosxy();
		
		c1[0]+=c2[0];
		c1[1]+=c2[1];
		
		double finaldist = Math.floor(Math.sqrt(Math.pow(c1[0],2)+Math.pow(c1[1], 2)));
		this.distance=finaldist;
		
		this.direction = Math.floor(Math.asin(c1[1]/finaldist))*Math.PI/180;
	}
	
	public String toString(){
		String s1 = distance*10 + " miles ";
		String s2;
		String s3 = " of the center of the world.";
		
		if(22<=direction&&direction<78){
			s2="NE";
		}else if(78<=direction&&direction<112){
			s2="N";
		}else if(112<=direction&&direction<158){
			s2="NW";
		}else if(158<=direction&&direction<202){
			s2="W";
		}else if(202<=direction&&direction<248){
			s2="SW";
		}else if(248<=direction&&direction<292){
			s2="S";
		}else if(292<=direction&&direction<338){
			s2="SE";
		}else{
			s2="E";
		}
		
		return s1+s2+s3;
		
	}
}

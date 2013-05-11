package worldElements;
import util.Position;

public abstract class Person {
	Position pos;
	String name;
		
	public Person(String name) {
		this.name = name;
		pos = new Position(0,0);
	}
	
	public void move(int dist, int theta){
		pos.move(dist, theta);
	}

}

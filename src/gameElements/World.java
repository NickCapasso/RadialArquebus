package gameElements;

import util.Position;
import worldElements.*;

import java.util.Random;
import java.util.ArrayList;


public class World {
	public ArrayList<Place> places;
	private ArrayList<Person> npcs;
	private Player player;
	
	public World(){
		generateWorld();
	}
	
	public Place[] getInfluencingPlaces(Place center){
		ArrayList<Place> iplaces= new ArrayList<Place>(0);
		for(int n=0;n<places.size();n++){
			if (center.isInfluencedBy(places.get(n))){
				iplaces.add(places.get(n));
			}
		}
		return iplaces.toArray(new Place[iplaces.size()]);
	}
	
	public Place[] getInfluencingPlaces(Position p){
		Biome temp = new Biome(p,0,this);
		return getInfluencingPlaces(temp);
	}
	
	/**
	 * World generation methods ONLY below. 
	 */
	void generateWorld(){
		places = new ArrayList<Place>();
		Random r= new Random();
		generateBiomes(r);
		generateCities(r);
		addPlayer();
	}
	
	private void generateBiomes(Random r){
		BiomeType[] types = BiomeType.values();
		for(int n = 0;n<10;n++){
			double dist = r.nextInt(200)-100;
			double theta = r.nextInt(360);
			BiomeType type = types[r.nextInt(types.length-1)+1];
			Position pos = new Position(dist,theta);
			int radius = r.nextInt(25)+25;
			places.add(new Biome(pos,radius,type));
		}
	}
	
	private void generateCities(Random r){
		for(int n=0;n<7;n++){
			double dist = r.nextInt(200)-100;
			double theta = r.nextInt(360);
			City city = new City (new Position(dist,theta), this);
			city.setPop(city.getMaxPop(this));
			places.add(city);
		}
	}
	
	private void addPlayer(){
		player = new Player("Placeholder");
	}
	
	public void movePlayer(int dist,int theta){
		player.move(dist,theta);
	}

	public void playerLoc() {
		player.printPos();
	}
	
}

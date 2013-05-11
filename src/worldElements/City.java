package worldElements;
import gameElements.World;
import util.*;

public class City extends Place {
	private int population;
	private int wealth;
	private int food;
	private int maxpop;
	private int maxfood;
	private int agriValue;
	String name;
	
	final int CITY_DENSITY = 550;
	final int BASE_MAX_FOOD = 9700;
	
	public City(Position loc, World world){
		location = loc;
		population = 0;
		wealth = 0;
		food = 1000;
		radius = radCalc(population);
		name = CityNames.values()[(int) Math.floor(Math.random()*CityNames.values().length)].toString();
	}
	
	public City grow(){
		food+= population*agriValue;
		if(food>population/2){
			food-=population/2;
			if(population<maxpop){
				population+=wealth;
			}else if(population>maxpop){
				population-=1.3*wealth;
			}
		}
		if(food<maxfood){
			wealth+=2*(food-maxfood);
			food=maxfood;
		}
		
		wealth+=0;//TODO earn money
		
		return this;
	}
	
	public int getMaxPop(World container){
		Place[] iplaces = container.getInfluencingPlaces(this);
		for(int n=0;n<iplaces.length;n++){
			if(iplaces[n] instanceof Biome){
				agriValue+=((Biome)iplaces[n]).getType().agriValue;
			}else if(iplaces[n] instanceof GeoFeature){
				
			}
		}
		int agriProduction = 1000*agriValue;
		return (int) Math.ceil(agriProduction/2);
	}
	
	protected int radCalc(int pop){
		return (int) (Math.ceil(Math.sqrt(pop/(CITY_DENSITY*Math.PI))));
	}

	public int getMaxpop() {
		return maxpop;
	}
	
	public void setMaxpop(int maxpop){
		this.maxpop=maxpop;
	}
	
	public void setPop(int pop){
		population = pop;
	}
}

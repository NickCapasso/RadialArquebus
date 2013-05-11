package worldElements;

import gameElements.World;
import util.Position;

public class Biome extends Place {
	private BiomeType type;
	
	public Biome(Position position, int ROI, World world) {
		super(position, ROI, world);
		type = BiomeType.PLAINS;
	}
	
	public Biome(Position position, int ROI, BiomeType type){
		this.location=position;
		this.radius = ROI;
		this.type = type;
	}
	
	public BiomeType getType(){
		return type;
	}
}

package worldElements;

public enum BiomeType {
	PLAINS(-3),
	FOREST(2),
	JUNGLE(3),
	ASHFIELD(4),
	OCEAN(0),
	MTNRANGE(1),
	SWAMP(0);
	
	public int agriValue;
	
	private BiomeType(int agriValue){
		this.agriValue=agriValue;
	}
	
	
}

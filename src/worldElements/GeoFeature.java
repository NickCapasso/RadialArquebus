package worldElements;

import gameElements.World;
import util.Position;

public class GeoFeature extends Place {
	public GeoType type;
	
	GeoFeature(Position position, int ROI, World world) {
		super(position, ROI, world);
		type = GeoType.PEAK;
	}
	

}

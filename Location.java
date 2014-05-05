import java.util.*;
public class Location {
		private int xMax = 2, xMin = 0, yMax = 3, yMin = 0;
		private int maxLocation = 9;
		private String locationText;
		private Inventory locationInv;
		private String viewText;
		private String useabeItem;
		private Map<String,Location> exits;
	public Location(String display, Inventory gInventory, String lookDisplay, Item currentItem){
		locationText = display;
		locationInv = gInventory; 
		viewText = lookDisplay;
		exits = new HashMap<String,Location>();
		if (currentItem != null ){
			useabeItem = currentItem.getName();
		}else{
			useabeItem = "There's no point in doing that...";
		}
	}

	public void setExits(Location north, Location south, Location east, Location west){
		if (north != null) {
			exits.put("north", north);
		}
		if (north != null) {
			exits.put("south", south);
		}
		if (north != null) {
			exits.put("west", west);
		}
		if (north != null) {
			exits.put("east", east);
		}

	}
	public String getDisplay(){
		return locationText;
	}
	public boolean hasInv(){
		if (this.locationInv == null){
			return false;
		}else if (locationInv.detSize() == null){
			return false;
		}else{
			return true;
		}
	}
	public Inventory getInventory(){
		return locationInv;
	}
	public String getLookDisplay(){
		return viewText;
	}
	public String getUseItem(){
		return useabeItem;
	}
	public Location newLocation(String direction){
		Location newLoc = exits.get(direction);
		return newLoc;
	}
}
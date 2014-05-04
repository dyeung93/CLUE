import java.util.*;
public class Location {
		private int xMax = 2, xMin = 0, yMax = 3, yMin = 0;
		private int maxLocation = 9;
		private  int positionX;
		private int positionY;
		private String locationText;
		private Inventory locationInv;
		private String viewText;
		private String useabeItem;
	public Location(String display, int x, int y, Inventory gInventory, String lookDisplay, Item currentItem){
		locationText = display;
		positionY = y;
		positionX = x;
		locationInv = gInventory; 
		viewText = lookDisplay;
		if (currentItem != null ){
			useabeItem = currentItem.getName();
		}else{
			useabeItem = "There's no point in doing that...";
		}
	}
	public int getX(){
		return positionX;
	}
	public int getY(){
		return positionY;
	}
	public boolean checkPos(String direction){
		if (positionX == 1 && positionY == 3 && direction.equals("north")){
			return true;
		}else if (positionX >= xMax && direction.equals("east")){
			return false;
		}else if (positionX <= xMin && direction.equals("west")){
			return false;
		}else if (positionY <= yMin && direction.equals("south")){
			return false;
		}else if (positionY >= yMax && direction.equals("north")){
			return false;
		}else{
			return true;
		}
	}
	public void setPos(String direction){
		if (direction.equals("north")) {
			positionY++;
		}else if (direction.equals("south")){
			positionY--;
		}else if (direction.equals("east")){
			positionX++; 
		}else if (direction.equals("west")){
			positionX--;
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
}
public class Action {
	private Location currentLoc;
	private String command, command2;
	private Item[] itemList = new Item[3]; 
	private Inventory actionInv = new Inventory(null,null,null);
	//private Inventory newInventory;
	public Action(Location currentLocation, String words0, String words1){
		this.currentLoc = currentLocation;
		this.command = words0;
		this.command2 = words1;
	}

	public Location goTo(String direction, Location currentLoc){
		return currentLoc.newLocation(direction);
	}	
	public Inventory displayItems(Location[] loc){
		return null;
	}	
	public Inventory getInventory(Location newLocation){
		if (newLocation.hasInv()) {
			actionInv = newLocation.getInventory();
			itemList = actionInv.getAllItems();
			if (actionInv.detSize() == 1){
				System.out.print("The only objects you see worth taking is a ");
			}else {
				System.out.print("The only objects you see worth taking are ");
			}
			for(int i = 0; i < 3; i++){
				if (itemList[i] != null){
			 		System.out.print(itemList[i].getName() + " ");
				}
			}
			System.out.println();
		}else{
			System.out.println("There aren't any useful items here..");
			System.out.println();
		}
		return actionInv;
	}
	public void setLocation(Location newLocation){
		this.currentLoc = newLocation;
	}
	public Item getItem(Inventory currentInv, String item ){
		itemList = currentInv.getAllItems();
		for(int i = 0; i< 3; i++){
			if(itemList[i] != null && itemList[i].getName().equals(item)) {
				return itemList[i];
			}
		}
		return null;
	}
	public void removeItem(Inventory currentInv, String item){
		itemList = currentInv.getAllItems();
		for(int i = 0; i< 3; i++){
			if(itemList[i] != null && itemList[i].getName().equals(item)) {
				itemList[i] = null; // nulls the place henceforth removing
			}
		}
	}
	public void setWord2(String secondword){
		this.command2 = secondword;
	}
	public void useItem(Item item){
		System.out.println(currentLoc.getUseItem());
	}

}
import java.util.*;
public class Inventory{
	private Item[] inv = new Item[3];

	public Inventory(Item item1, Item item2, Item item3){
		this.inv[0] = item1;
		this.inv[1] = item2;
		this.inv[2] = item3;
	}
	public Item getItem(String name){
		for(int i = 0; i < 3; i++){
			String check = inv[i].getName();
			if(check.equals(name)){
				return inv[i];
			}
		}
		return null;
	}
	public Item[] getAllItems(){
		return inv;
	}
	public Integer detSize(){
		if (inv[0] == null){
			return null;
		}else if (inv[1] == null){
			return 1;
		}else if (inv[2] == null){
			return 2;
		}else{
			return 3;
		}
	}

}
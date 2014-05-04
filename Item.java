import java.util.*;
public class Item {
	private String itemText;
	private String itemName;
	private String itemPurpose;
	public Item(String name, String description, String purpose){
		this.itemText = description;
		this.itemName = name;
		this.itemPurpose = purpose;
	}
	public String getDescription(){
		return itemText;
	}
	public String getName(){
		return itemName;
	}
	public String getAction(){
		return itemPurpose;
	}


}



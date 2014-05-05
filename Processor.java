import java.util.*;

public class Processor{
	private Location currentLoc;
	private Location[] loc = new Location[13];
	private Inventory currentInv; // location Inventory and personal inventory
	private Item[] newItem = new Item[10]; // location then num of objects
	private Item currentItem;
	private Map<String, Item> myInventory = new HashMap<String, Item>();
	private boolean endFlag;
	private String secondWord;
	//Item stuff
	private Inventory[] gInventory = new Inventory[7];
	private Map<String,String> commandList = new HashMap<String,String>();
	private Map<String,String> secondWordList = new HashMap<String,String>();
	private boolean showHint;
	//private GameState currentState;
	private void createItems(){
		newItem[0] = new Item("Knife","The blade is kinda sharp.. perfect for killing someone", null);
		newItem[1] = new Item("Candlestick","Used to hold a candle.. freshly cleaned too", "You use your candlestick to light up the room, nothing special shows up");
		newItem[2] = new Item("Rope","Just some good ole rope", null);
		newItem[3] = new Item("Gun","Bang Bang, it says its the property of Col. Mustard", null);
		newItem[4] = new Item("Posion","Has a big X on the side of the container", null);
		newItem[5] = new Item("ID","Its your ID, sherlock..how'd that get here?..", null);
		newItem[6] = new Item("Bat","Its a wooden baseball bat, you could probably hit stuff with this", null);
		newItem[7] = new Item("Col's body","Strange wound on his head but also strains on his neck..", null);
		newItem[8] = new Item("Book","He must've been a very important person as they are all leather bounded", null);
		newItem[9] = new Item("Key","Its a nice looking key","You open the chest and see a picture of Col. Mustard..hmm he looks different than what I remember");
		gInventory[0] = new Inventory(newItem[0], newItem[4], null); // Kitchen Inv: Knife, posion
		gInventory[1] = new Inventory(newItem[6], null, null); // (2,0) Joe's inv: Baseball Bat 
		gInventory[2] = new Inventory(newItem[2], null, null); // Eric's inv: Rope
		gInventory[3] = new Inventory(newItem[3], newItem[7],null); // Col Mus: body, gun
		gInventory[4] = new Inventory(newItem[1], null, null); //Hallway: candlestick
		gInventory[5] = new Inventory(newItem[9], null, null); //Your room: id
		gInventory[6] = new Inventory(newItem[8], newItem[5], null); //Library: books

		currentInv = new Inventory(null,null,null);
	} 

	private void createLocations(){
		Location kitchen, dining, col_mus, library, hallway, gameRoom, entrance, plum, scarlet, white, green, peacock, end;
			end = new Location("You are outside talking to the cops.. What do you think killed him?", null, null, null);
			kitchen = new Location("You are in the kitchen", gInventory[0], "The kitchen, I doubt there's any food there", null);
			dining = new Location("You are in the dining room, everyone's gone", null,"The dining room, food is still half finished", null);
			col_mus = new Location("You are in the bedroom of Col Mustard", gInventory[3],"The ghost of col Mustard..kinda freaky", null);
			library = new Location("You are in the library...everything's quiet", gInventory[6],"The library, the books are all leather bounded...", newItem[8]);
			green = new Location("You are in the bedroom where you awoke..Look's like its Mr. Green's room", gInventory[5],"The bedroom where you awoke, it looks dark and nasty", newItem[9]);
			hallway = new Location("You are in the hallway..fancy paintings on the wall but nothing special ", gInventory[4],"The hallway..its long and empty and hallwayish", null);
			gameRoom = new Location("You are in the game room", null,"The hallway, its long and stretches", null);
			entrance = new Location("You're at the entrance of the house.. Do you want to go out now? (Go north for yes)(Ends the game)", null,"a door, a big old wooden door", null);
			scarlet = new Location("You are in the room Miss Scarlet was staying at..kinda dark in here", gInventory[1],"Miss Scarlet's room.. let's look through her stuff", newItem[1]);
			white = new Location("You are in the room Ms. White was staying at..kinda dark in here", null,"Ms White's room.. let's look through her stuff", newItem[1]);
			peacock = new Location("You are in the room Mrs.Peacock was staying at..kinda dark in here", gInventory[2],"Mrs. Peacock's room .. lets look through her stuff", newItem[1]);
			plum = new Location("You are in the room Professor Plum was staying at.. kinda dark in here", null,"Prof. Plum's room.. lets look through his stuff", newItem[1]);
			loc[0] = kitchen;
			loc[1] = dining;
			loc[2] = col_mus;
			loc[3] = library;
			loc[4] = green;
			loc[5] = hallway;
			loc[6] = gameRoom;
			loc[7] = entrance;
			loc[8] = scarlet;
			loc[9] = plum;
			loc[10] = white;
			loc[11] = peacock;
			loc[12] = end;

			kitchen.setExits(gameRoom,white,null,dining);
			dining.setExits(hallway,green,kitchen,plum);
			col_mus.setExits(null,white,entrance,null);
			library.setExits(null,gameRoom,null,entrance);
			green.setExits(dining,null,scarlet,white);
			hallway.setExits(entrance,dining,peacock,gameRoom);
			gameRoom.setExits(library,kitchen,null,hallway);
			entrance.setExits(end,hallway,library,col_mus);
			scarlet.setExits(plum,null,green,null);
			white.setExits(kitchen,null,null,green);
			peacock.setExits(col_mus,plum,hallway,null);
			plum.setExits(peacock,scarlet,dining,null);
			

			
			String startMessage = "The first thing you do is..";
			currentLoc = green;

	}
	private void createCommands(){
		commandList.put("Go", "go");
		commandList.put("go", "go");

		commandList.put("Use","use");
		commandList.put("use","use");

		commandList.put("Look","look");
		commandList.put("look","look");

		commandList.put("Take","take");
		commandList.put("take","take");

		commandList.put("Drop","drop");
		commandList.put("drop", "drop");

		commandList.put("Examine", "examine");
		commandList.put("examine", "examine");

		commandList.put("List", "list");
		commandList.put("list", "list");

		commandList.put("Show", "show");
		commandList.put("show", "show");

		commandList.put("Hide", "hide");
		commandList.put("hide", "hide");

	}
	private void createSecondWords(){
		secondWordList.put("Up", "north");
		secondWordList.put("up", "north");
		secondWordList.put("down", "south");
		secondWordList.put("Down", "south");
		secondWordList.put("left", "west");
		secondWordList.put("Left", "west");
		secondWordList.put("right", "east");
		secondWordList.put("Right", "east");

		secondWordList.put("North", "north");
		secondWordList.put("north", "north");
		secondWordList.put("south", "south");
		secondWordList.put("South", "south");
		secondWordList.put("Wast", "west");
		secondWordList.put("west", "west");
		secondWordList.put("East", "east");
		secondWordList.put("east", "east");

	}
	private void welcomeMessage(){
		System.out.println();
		System.out.println("You wake up on the floor dizzy.. Someone hit your head and knocked you out..");
		System.out.println("A small puddle of blood lays next to you... ");
		System.out.print("You remember you were at a dinner party with very important people when suddenly");
		System.out.println("you saw Col. Mustard, the host, being killed by a shadowy figure. ");
		System.out.println("You decide to play detective and go look for clues before the police come..");
	}
	public Processor(){	//constructor
		createItems();
		createLocations();
		createCommands();
		createSecondWords();
		welcomeMessage();
		endFlag = true;
		showHint = false;
		System.out.println(currentLoc.getDisplay());
	}
	public void processCommand(String command){
		String[] word = parseCommand(command);

		if (secondWordList.containsKey(word[1])){
			secondWord = secondWordList.get(word[1]); 
		}else{
			System.out.println("Nope not a valid thing to do");
			return;
		} //Checks if a valid command

		System.out.println(); //prints out a line space 
		determineAction(word);
	}
	public String[] parseCommand(String command){
		return command.split(" ");
	}
	public void closing(){
		System.out.println("You got it right! It was indeed a baseball bat...");
		System.out.println("Just as you are about the hand over the bat, you realize all of a sudden..");
		System.out.println("YOU'RE DEAD, turns out Col. Mustard is just a fictional character in the game CLUE");
		System.out.println("Seriously man..way to be a detective");
	}
	public void endState(String[] words){
		if (!myInventory.containsKey(words[1])){
			System.out.println("You either don't have that or did not put in an item ie: the Ball");
			return;
		}else{
			if (words[1].equals("Bat")){
				closing();
			}else{
				System.out.println("Unfortunately nope, the answer was a baseball bat...Guess you're not a good detective");
			}
			endFlag = false;
		}
	}
	public boolean endGame(){
		return endFlag;
	}
	public void determineAction(String[] words){
		Action action = new Action(currentLoc, words[0], words[1]);
		Location newLoc;
		if (words[0].equals("go")){
			newLoc = action.goTo(secondWord, currentLoc);
		}
	}


}
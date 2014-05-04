import java.util.*;

public class Adventure {

	public static void main(String[] args){
		System.out.println("Welcome to this game based off of clue");
		Scanner input = new Scanner(System.in);
		Processor processor = new Processor();
		String command = "";
		Boolean gameOver = true;

		while(!command.equals("quit") && gameOver){
		try { 
			System.out.print(">>");
			command = input.nextLine();
			processor.processCommand(command);
			gameOver = processor.endGame();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You need to type in 2 words for a command...ie : go north");
		}
			//System.out.println(printOut);
		}
	}
}
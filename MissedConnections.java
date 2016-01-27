import java.util.Scanner;

/**
 * 
 * First attempt at make a basic text-based game in Java. Inspired by a true story a 
 * friend told hours before writing this program. This one is for you. ;) 
 * 
 * Author: Christina Halstead
 * 
 */
public class MissedConnections {
	
	/**
	 * This method displays a pause method and waits until the
	 * user presses the return key.
	 */
	public void pause(Scanner scanner) {
		System.out.println("--- Push <Enter> to continue ---");
		scanner.nextLine();
	}
	
	/**
	 * Generates a random int that can be from 0 to
	 * the number passed in as an argument.
	 */
	public int randomNumber(int maxNum) {
		// ADVANCED FEATURE: Generating a random number
		/* We add 1 to the number because because without it, it
		 * will return only [maxNum] possible integers, starting
		 * at zero.
		 */
		return (int) (Math.random() * (maxNum + 1));
	}
	
	/**
	 * Simulates a round between the player and the npc, where
	 * the NPC is attacking first.
	 */
	public void playRound(int roundNum, NPC npc, Player player) {
	

		System.out.println("[[ ROUND " + roundNum + " ]]");

		// Determines the attack power from both characters at the
		// start of the round, this value is used in the message
		// that's printed to the user and used to change the
		// character's health points.
		int randomNpcATK = randomNumber(npc.atk);
		int randomPlayerATK = randomNumber(player.atk);
		
		// Let the NPC attack first
		if (randomNpcATK < player.def) {
		   System.out.println("\t" + player.name + " unfazed by " + npc.name + "'s comment!");
		} else {System.out.println(npc.name + " attacks your ego for " + randomNpcATK + " points!");
		player.hp -= randomNpcATK;
		}

		

		System.out.println(player.name + " has " + player.hp + "  patience left.");

		// Then the Player attacks
		System.out.println(player.name + " attacks Ex's ego for " + randomPlayerATK + " points!");
		

		if (randomPlayerATK < npc.def) {
			System.out.println("\t" + npc.name + " points out flaw in " + player.name + "'s argument!");
		} else {
			npc.hp -= randomPlayerATK;
		}


		System.out.println(npc.name + " has " + npc.hp + " patience left.");
 


		System.out.println();
	}
	
	public static void main(String[] args) {
		MissedConnections m = new MissedConnections();
		
		// Creates a single scanner for use throughout the program
		Scanner scanner = new Scanner(System.in);


		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Welcome to...");
		System.out.println(
			
"---------------------------------\n" +
"---------------██████████───────-\n" +
"--------------████████████──────-\n" +
"--------------██────────██──────-\n" +
"--------------██▄▄▄▄▄▄▄▄▄█──────-\n" +
"--------------██▀███─███▀█──────-\n" +
"█-------------▀█--------█▀──────-\n" +
"██------------------█------------\n" +
"─█──────────────██---------------\n" +
"█▄────────────████─██──████------\n" +
"─▄███████████████──██──██████ ──-\n" +
"────█████████████──██──█████████-\n" +
"─────────────████──██─█████──███-\n" +
"──────────────███──██─█████──███-\n" +
"--------------███─────█████████--\n" +
"---------------██─────████████▀--\n" +
"----------------██████████-------\n" +
"----------------██████████-------\n" +
"-----------------████████--------\n" +
"------------------██████████▄----\n" +
"-------------------█████████▀----\n" +
"---------------------████──███---\n" +
"--------------------▄████▄──██---\n" +
"--------------------██████───▀---\n" +
"--------------------▀▄▄▄▄▀-------\n" +
"---------------------------------\n" +
"Missed Connections: Bar Edition!!!\n" +
"---------------------------------\n"
);

		System.out.print("--- Push <Enter> to continue ---");
		scanner.nextLine();
		System.out.println();

        //User's can enter character name
		String playerName;
		System.out.print("Enter your character's name: ");
		playerName = scanner.nextLine();
        
        //User's can enter character gender
		String gender;
		System.out.print("Character Gender (m or f): ");
		gender = scanner.nextLine();

		m.pause(scanner);

// Creates a Non-Playable-Character / NPC in World
		NPC npc1 = new NPC("Ex", 40, 9, 3);
		
		// Creates a Player object
		Player player = new Player(playerName, 50, 8, 2);


		// Displays the story
		System.out.println("It has been a long week and you have decided to go out");
		System.out.println("with your friends. As you are drinking, you notice someone"); 
		System.out.println("sitting at the bar that you are interested in. You decide to make a move.\n"); 
		

		m.pause(scanner);
		 
		System.out.println("Walking over to the bar you suddenly hear a familiar voice.");
		System.out.println("Turning to investigate, you see someone standing between you and the bar.");
		System.out.println("The person starts to approach you.\n");

		m.pause(scanner);

		System.out.println("You've just been ambushed by your ex!!!\n");

		m.pause(scanner);
		
		// Battle a few rounds against the NPC
		
		
		int round = 1;
        while (round <= 8) {

        m.playRound(round++, npc1, player);
		m.pause(scanner); }
		
		


		// Abruptly end the game
		System.out.println("Game Over. Your potential soulmate left the bar. Seems like you'll never win.");
	}


	
}
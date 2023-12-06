import java.util.Random;
import java.util.ArrayList;

public class MegaMillions {
	
	static ArrayList<Integer> winningTicket = new ArrayList<Integer>();
	static ArrayList<Integer> ticket = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		boolean winner = false;									// If it has won or not to stop the loop
		double spent = 0.0;										// how much money has been spent
		Random rand = new Random();
		
		for (int i = 1; i <= 5; i ++) {
			int num = rand.nextInt(70)+1;			// Figures out the first 5 numbers of the winning ticket.
			winningTicket.add(num);	
		}
		winningTicket.add(rand.nextInt(25)+1);
		
		while (winner == false) {
			
			spent += 2.0;
			
			for (int i = 1; i <= 5; i ++) {
				ticket.add(rand.nextInt(70)+1);
			}
			ticket.add(rand.nextInt(25)+1);
			
			if (ticket == winningTicket) {
				winner = true;
			}
			else {
				ticket.clear();
			}
			
		}
	
		
		
		
		
		
		
		System.out.printf("You finally won! The winning ticket was %s", winningTicket);
		System.out.printf("You have spent a total of $%f on playing the MegaMillions, thanks for playing!", spent);
	}

}

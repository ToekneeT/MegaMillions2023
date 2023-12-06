import java.util.Random;
import java.util.ArrayList;

class MegaMillions extends Thread {
    static ArrayList<Integer> lotto = new ArrayList<Integer>();
    ArrayList<Integer> ticket = new ArrayList<Integer>();
    static volatile boolean winner = false;
    public double spent = 0;
    public long ticketsBought = 0;
    static void winningTicket() {
        Random rand = new Random();
        for (int i = 1; i <= 5; i++) {
            // Figures out the first 5 numbers of the winning ticket.
            int num = rand.nextInt(70) + 1;
            lotto.add(num);
        }
        lotto.add(rand.nextInt(25) + 1);
    }

    public void run() {
        // how much money has been spent
        Random rand = new Random();

        while (!winner) {

            spent += 2.0;
            ticketsBought += 1;

            for (int i = 1; i <= 5; i++) {
                ticket.add(rand.nextInt(70) + 1);
            }
            ticket.add(rand.nextInt(25) + 1);

            if (ticket.equals(lotto)) {
                winner = true;
            } else {
                ticket.clear();
            }
        }
    }
}

public class MegaMillions2023 {
    public static void main(String[] args) throws InterruptedException {
        int n = 12;
        long totalTicketsBought = 0;
        double total = 0;
        MegaMillions[] tickets = new MegaMillions[n];
        MegaMillions.winningTicket();
        for(int i = 0; i < n; i++) {
            tickets[i] = new MegaMillions();
            tickets[i].start();
        }
        while(!MegaMillions.winner) {
            Thread.sleep(60000);
        }
        for (MegaMillions t : tickets) {
            total += t.spent;
            totalTicketsBought += t.ticketsBought;
        }
        System.out.printf("You finally won! The winning ticket was %s\n", tickets[0].lotto);
        System.out.printf("You have spent a total of $%.2f on playing the MegaMillions, thanks for playing!\n", total);
        System.out.printf("You bought %d tickets.", totalTicketsBought);
    }
}
package casino;

public class SlotMachine implements Playable {
	public SlotMachine(){
		
	}
	
	public void winMessage(Player player, int bet, int result, int allcredits) {
		System.out.printf("Glückwunsch sie haben Gewonnen!!!\n"
				+ "Einsatz: %d\n"
				+ "Gewinn: %d\n"
				+ "Ihr Gesamtguthaben beträgt nun %d Credits", bet, result, allcredits);
	}
	
	public void loseMessage(Player player, int bet, int allcredits) {
		System.out.printf("Leider haben Sie verloren!!!\n"
				+ "Verlorene Credits: %d\n"
				+ "Ihr Gesantguthaben beträgt nun %d Credits", bet, allcredits);
	}
	
	
	public void playRound(Player player, Croupier croupier, int bet, int creditBet ,int allcredits) {
		if(croupier.performRole(bet, player.getCredits()) == true) {		//Hier habe ich mir einer for-Schleife es so gemacht das es eine Animation gibt
			allcredits -= creditBet;
			int result1; int result2; int result3;
			result1 = (int)(Math.random() * (1 + 4 - 0) + 1); result2 = (int)(Math.random() * (1 + 4 - 0) + 1); result3 = (int)(Math.random() * (1 + 4 - 0) + 1);
			for(int i = 0; i <= 30; i++) {
			if(i <= 10) {result1 = (int)(Math.random() * (1 + 4 - 0) + 1); result2 = (int)(Math.random() * (1 + 4 - 0) + 1); result3 = (int)(Math.random() * (1 + 4 - 0) + 1);}
			else if(i <= 20) {result2 = (int)(Math.random() * (1 + 4 - 0) + 1); result3 = (int)(Math.random() * (1 + 4 - 0) + 1);}
			else {result3 = (int)(Math.random() * (1 + 4 - 0) + 1);} 
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(""
					+ "+------------------------+\n"
	                 + "|      SLOT MACHINE     |\n"
	                 + "+-------+-------+-------+\n"
	                 + "|   " + result1 + "   |   " + result2 + "   |   " + result3 + "   |\n"
	                 + "+-------+-------+-------+\n"
	                 + "|        [ SPIN ]       |\n"
	                 + "+------------------------+");
			try {
				Thread.sleep(100);}														
				catch(InterruptedException e){											
					Thread.currentThread().interrupt();}}
			if(result1 == result2 && result1 == result3 && result2 == result3) {
				allcredits += creditBet*5;
				winMessage(player, creditBet, creditBet*5, allcredits);
				}
			else if(result1 == result2 || result1 == result3 || result2 == result3) {
				allcredits += creditBet*2;
				winMessage(player, creditBet, creditBet*2, allcredits);}
			else {loseMessage(player, creditBet, allcredits);}}
		else {System.out.println("Leider können sie nicht spielen");}
	}
	
	
	
	
}

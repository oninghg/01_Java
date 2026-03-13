package casino;

public class Roulette implements Playable {
	public Roulette() {
		
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
				+ "Ihr Gesamtguthaben beträgt nun %d Credits", bet, allcredits);
	}
	
	
	public void playRound(Player player, Croupier croupier, int bet, int creditbet,  int allcredits) {
		if (croupier.performRole(creditbet, allcredits) == true) {
			allcredits -= creditbet;
			int result = (int)(Math.random() * (0 + 36 - 0) + 0);
			if(result == bet) {
				allcredits += creditbet * 7;
				System.out.println("Der Ball landet auf: [" + result + "]");
				winMessage(player, creditbet, creditbet*7, allcredits);}
			else if(result % 2 == 0 && bet == 40) {
				allcredits += creditbet * 3;
				System.out.println("Der Ball landet auf: [" + result + "]");
				winMessage(player, creditbet, creditbet*3, allcredits);}
			else if(result % 2 == 1 && bet == 41) {
				allcredits += creditbet * 3; 
				System.out.println("Der Ball landet auf: [" + result + "]");
				winMessage(player, creditbet, creditbet*3, allcredits);}
			else if(result == 0 && bet == result) {
				allcredits += creditbet * 10; 
				System.out.println("Der Ball landet auf: [" + result + "]");
				winMessage(player, creditbet, creditbet*10, allcredits);}
			else {System.out.println("Der Ball landet auf: [" + result + "]");
				loseMessage(player, creditbet, allcredits);}
		}
		}
	

	
}

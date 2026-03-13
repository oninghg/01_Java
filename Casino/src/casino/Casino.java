package casino;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Casino {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	Croupier croupier = new Croupier("Der korrupte Matthi");
	Playable[] playables = new Playable[]{new Roulette(), new SlotMachine()};
	int decision = 0;

	Player player = createPlayer(scan);
	while(decision!= 5) {										//While wenn es nicht 5 ist soll weiter gehen
	decision = welcomeing(scan);
	Roulette(scan, decision, player, playables, croupier);
	SlotMachine(scan, decision, player, playables, croupier);
	buyCredits(scan, decision, player);}
	
	}
	
	public static Player createPlayer(Scanner scan) {			//Methode um Spieler zu erstellen
		System.out.println("Wie ist denn Ihr Name: "); 
		String name = scan.nextLine();
		System.out.println("Mit wie vielen Credits wollen Sie spielen (mind. 30)");
		int credits = scan.nextInt(); scan.nextLine();
		if(credits >= 30) {return new Player(name, credits);}	//wenn der Spieler weniger als 30 Credits angibts startet er automatisch mit 30
		else {System.out.println("Zu wenig Credits genommen (jetzt musst du mit 30 auskommen)");
		return new Player(name, 30);}
	}
	
	
	public static int welcomeing(Scanner scan) {
		int deci = 0;
		System.out.println("   █████████                     ███                           █████████                      ████ \r\n"
				+ "  ███░░░░░███                   ░░░                           ███░░░░░███                    ░░███ \r\n"
				+ " ███     ░░░   ██████    █████  ████  ████████    ██████     ███     ░░░   ██████    ██████   ░███ \r\n"
				+ "░███          ░░░░░███  ███░░  ░░███ ░░███░░███  ███░░███   ░███          ░░░░░███  ░░░░░███  ░███ \r\n"
				+ "░███           ███████ ░░█████  ░███  ░███ ░███ ░███ ░███   ░███    █████  ███████   ███████  ░███ \r\n"
				+ "░░███     ███ ███░░███  ░░░░███ ░███  ░███ ░███ ░███ ░███   ░░███  ░░███  ███░░███  ███░░███  ░███ \r\n"
				+ " ░░█████████ ░░████████ ██████  █████ ████ █████░░██████     ░░█████████ ░░████████░░████████ █████\r\n"
				+ "  ░░░░░░░░░   ░░░░░░░░ ░░░░░░  ░░░░░ ░░░░ ░░░░░  ░░░░░░       ░░░░░░░░░   ░░░░░░░░  ░░░░░░░░ ░░░░░ \r\n");
		System.out.println("Herzlich Willkommen im Casino Gaal\n"
				+ "Sie können nun zwischen zwei Spielen auswählen, sich Credits kaufen oder sich ihre Credits anzeigen lassen\n"
				+ "[1] Roulette\n"
				+ "[2] Slot Machine\n"
				+ "[3] Credits kaufen\n"
				+ "[4] Credits anzeigen lassen\n"
				+ "\n"
				+ "[5] Exit");								//Menü
		try { deci =  scan.nextInt(); }
		catch(InputMismatchException ex) {System.err.println("Leider keine gültige Eingabe bitte eine Zahl eingeben!");} 
		scan.nextLine();
		return deci;				}
	

	
	public static void Roulette(Scanner scan, int decision, Player player, Playable[] playables, Croupier croupier) {
	    if (decision == 1) {
	        int creditBet = 0;
	        int bet = 0;
	        System.out.println("Schön, Sie haben sich nun entschieden Roulette zu spielen, Viel Glück!");

	        try {
	            System.out.println("Wie viel möchten Sie setzen: ");
	            creditBet = scan.nextInt();
	            CreditCheck(player.getCredits(), creditBet);
	            System.out.println("Auf was möchten Sie setzen\n"
	                    + "Zahl von 0-36 [0-36]\n"
	                    + "Rot (gerade) [40]\n"
	                    + "Schwarz (ungerade) [41]");
	            bet = scan.nextInt();
	            RouletteBetCheck(bet);
	            scan.nextLine(); 
	            playables[0].playRound(player, croupier, bet, creditBet, player.getCredits());
	            // 5 secunden Pause
	            Thread.sleep(5000);

	        } catch (InputMismatchException e) {
	            System.out.println("Falsche Eingabe! Bitte geben Sie eine Zahl ein!");
	            scan.nextLine();
	        } catch (InvalidCreditsException | InvalidRouletteException ex) {
	            System.out.println(ex.getMessage());
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	        
	        System.out.println("\n\n\n");
	    }
	}
	
	
	
	public static void SlotMachine(Scanner scan, int decision, Player player, Playable[] playables, Croupier croupier) {
		if(decision == 2) {	//Wenn 2 angegeben wurde wird Slot Machine gestartet
			try {
			System.out.println("Schön, Sie haben sich entschieden an der Slot Machine zu spielen");
			System.out.println("Wie viel möchten Sie in den Automaten hauen");
			int bet = scan.nextInt(); scan.nextLine();
			CreditCheck(player.getCredits(), bet);
			playables[1].playRound(player, croupier, 0, bet, player.getCredits()); }
			catch(InvalidCreditsException ex) { System.out.println(ex.getMessage()); }
			catch(InputMismatchException e) { System.out.println("Falsche Eingabe! Geben Sie eine Zahl ein!"); }
			try {
				Thread.sleep(5000);}													//5 Sekunden Pause um Ergebnis zu sehen
				catch(InterruptedException e){											//Thread wird aufgefordert die zeitliche Pause zu beenden.
					Thread.currentThread().interrupt();	}								//*Hilfe von ChatGPT!*
			System.out.println("\n\n\n");}
		}
	
	
	public static void buyCredits(Scanner scan, int decision, Player player) {
		if(decision == 3) {						//Wenn 3 ausgewählt wurde kann man sich Credits kaufen	
			try {
			System.out.println("Wie viele Credits möchten Sie kaufen?: ");
			int boughtcredits = scan.nextInt(); scan.nextLine();
			CreditBuyCheck(boughtcredits);
			player.setCredits(boughtcredits);
			System.out.println("Sie haben nun: " + player.getCredits() + " Credits"); }
			catch(InvalidCreditsException ex) { System.out.println(ex.getMessage()); }
			catch(InputMismatchException e) { System.out.println("Falsche Eingabe! Geben Sie eine Zahl ein!"); }
			try {
				Thread.sleep(2000);}													//2 Sekunden Pause um Ergebnis zu sehen
				catch(InterruptedException e){											//Thread wird aufgefordert die zeitliche Pause zu beenden.
					Thread.currentThread().interrupt();}
			System.out.println("\n\n\n");}}
	
	
	public static void showCredits(int decision, Player player) {
		if(decision == 4) {																//Wenn 4 ausgegeben wurde kann man sich die credits anzeigen lassen 
			player.toString();
			try {
				Thread.sleep(2000);}													//2 Sekunden Pause um Ergebnis zu sehen
				catch(InterruptedException e){											//Thread wird aufgefordert die zeitliche Pause zu beenden.
					Thread.currentThread().interrupt();}
			System.out.println("\n\n\n");
		}
	}
	
	
	public static void CreditCheck(int credits, int setCredits) throws InvalidCreditsException {
		if(setCredits > credits) {
			throw new InvalidCreditsException("Falsche Eingabe! Es wurden zu viele Credits gesetzt"); }
		else if(setCredits <= 0) {
			throw new InvalidCreditsException("Falsche Eingabe! Es können nicht weniger Credits als null gesetzt werden"); }}
	
	public static void RouletteBetCheck(int bet) throws InvalidRouletteException {
		if(bet > 41 || bet < 0) {
			throw new InvalidRouletteException("Falsche Eingabe! Geben Sie eine gültige Wette ein!");
		}}
	
	public static void CreditBuyCheck(int credits) throws InvalidCreditsException{
		if(credits <= 0) {
			throw new InvalidCreditsException("Sie können nicht 0 oder negativ Credits kaufen!");
		}
	}


}
	


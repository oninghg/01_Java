package casino;

public class Croupier extends Persons {
	public Croupier(String name) {
		super(name);}
	
	@Override
	public boolean performRole(int credits, int allcredits) {
		if(credits <= allcredits / 2) {
			System.out.println("Der Spieler ist spielberechtigt!"); return true;}
		else {System.out.println("Der Spieler darf nicht so viel setzen"); return false;}
	}
}

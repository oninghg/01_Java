package casino;

public class Player extends Persons{
	private int credits;
	
	public Player(String name, int credits) {
		super(name);
		this.credits = credits;
	}
	
	public int getCredits() {
		return credits;}
	
	public void setCredits(int moreCredits) {
		credits += moreCredits;
	}
	
	@Override
	public boolean performRole(int credits, int allcredits) {
		System.out.println("Sie haben derzeit " + allcredits + " credits");
		if(allcredits > 0) {System.out.println("Sie sind spielberechtigt"); return true; }
		else {System.out.println("Sie sind nicht spielberechtigt weil sie keine Credits mehr haben"); return false;}
	}
	
	@Override
	public String toString() {
		return String.format("Sie haben derzeit %d Credits\n", credits);
	}
	
}

package casino;

public interface Playable {
	
	public void playRound(Player player, Croupier croupier, int bet, int creditbet,int allcredits);
	
	public void winMessage(Player player, int bet, int result, int allcredits);
	
	public void loseMessage(Player player, int bet,int allcredits);
}

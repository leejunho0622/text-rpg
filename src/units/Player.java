package units;

public class Player extends Unit{
	public Player(String name, String job, int hp, int mp, int damage, int def, boolean party) {
		super(name, job, hp, mp, damage, def, party);
	}
	
	@Override
	public String toString() {
		return String.format("[%s][%s][Lv. %d]\n[%d/%d][%d/%d][%s:%d][%s:%d]", getName(), getJob(), getLevel(), getHp(), getMaxHp(), getMp(), getMaxMp(), "⚔️", getDamage(), "🛡️", getDef());
	}
}

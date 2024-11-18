package units;

public class Monster extends Unit{
	public Monster(String name, int level, int hp, int damage, int def) {
		super(name, level, hp, damage, def);
	}
	
	@Override
	public String toString() {
		return String.format("[%s][Lv. %d]\n[HP:%d/%d][%s:%d][%s:%d]", getName(), getLevel(), getHp(), getMaxHp(), "⚔️", getDamage(), "🛡️", getDef());
	}
}

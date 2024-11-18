package units;

import interfaces.IOManager;

public class Monster extends Unit{
	public Monster(String name, int level, int hp, int damage, int def) {
		super(name, level, hp, damage, def);
	}
	
	@Override
	public String toString() {
		return String.format("[%s][Lv. %d]\n[HP:%d/%d][%s:%d][%s:%d]", getName(), getLevel(), getHp(), getMaxHp(), "⚔️", getDamage(), "🛡️", getDef());
	}
	
	public void attack(Player target) {
		int att = getDamage() - target.getDef();
		if(att <= 0)
			att = 1;
		String textTitle = String.format("\n%s에게 %d의 데미지!\n\n", target.getName(), att);
		IOManager.append(textTitle);
		target.decreaseHp(att);
		if(target.getHp() <= 0)
			target.setHp(0);
	}
}

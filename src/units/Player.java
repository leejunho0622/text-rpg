package units;

import interfaces.IOManager;

public class Player extends Unit{
	public Player(String name, String job, int hp, int mp, int damage, int def, int crit, boolean party) {
		super(name, job, hp, mp, damage, def, crit, party);
	}
	
	@Override
	public String toString() {
		return String.format("[%s][%s][Lv. %d]\n[HP:%d/%d][MP:%d/%d][%s:%d][%s:%d]", getName(), getJob(), getLevel(), getHp(), getMaxHp(), getMp(), getMaxMp(), "⚔️", getDamage(), "🛡️", getDef());
	}
	
	public void attack(Monster target) {
		int att = getDamage() - target.getDef();
		if(att <= 0)
			att = 1;
		String textTitle = String.format("\n%s에게 %d의 데미지!\n", target.getName(), att);
		IOManager.append(textTitle);
		target.decreaseHp(att);
		if(target.getHp() <= 0)
			target.setHp(0);
	}
}
